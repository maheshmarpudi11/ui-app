package com.ui.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ui.app.dto.ProductDTO;
import com.ui.app.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product-dashboard")
	public ModelAndView getProductDashboard() {
		
		List<ProductDTO> products = productService.getAllProducts();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-dashboard");
		mv.addObject("message1", "Product Dashboard");
		mv.addObject("message2", "Product Services");
		mv.addObject("product", new ProductDTO());
		mv.addObject("products", products);
		
		return mv;
		
	}
	
	@RequestMapping(value ="/create-product", method =  RequestMethod.POST)
	public ModelAndView createdProduct(ProductDTO product) {
		ModelAndView mv = new ModelAndView();
		
		if(product != null && product.getProductId() != null) {
			productService.updateProduct(product);
			mv.addObject("response", "product is updated.");
		}else {
			String repsonseObj  = productService.createProduct(product);
			mv.addObject("response", repsonseObj);
		}
		
		List<ProductDTO> products = productService.getAllProducts();
		
		mv.setViewName("product-dashboard");
		mv.addObject("message1", "Product Dashboard");
		mv.addObject("message2", "Product Services");
		mv.addObject("product", new ProductDTO());
		mv.addObject("products", products);
		
		return mv;
	}
	
	@RequestMapping("/update-product/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> products = productService.getAllProducts();
		
		ProductDTO productRes = productService.findProductById(id);
		
		mv.setViewName("product-dashboard");
		mv.addObject("message1", "Product Dashboard");
		mv.addObject("message2", "Product Services");
		mv.addObject("product",productRes);
		mv.addObject("products", products);
		
		return mv;
	}
	
	@RequestMapping("/delete-product/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> products = productService.getAllProducts();
		
		String response = productService.deleteProductById(id);
		
		mv.setViewName("product-dashboard");
		mv.addObject("response", response);
		mv.addObject("message1", "Product Dashboard");
		mv.addObject("message2", "Product Services");
		mv.addObject("product",new ProductDTO());
		mv.addObject("products", products);
		
		return mv;
				
	}
	
	
}
package com.ui.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.ui.app.AppConstants;
import com.ui.app.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	public String createProduct(ProductDTO product) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(product, headers);

		ResponseEntity<ProductDTO> response = restTemplate.exchange(AppConstants.CREATE_URL, HttpMethod.POST,
				httpEntity, ProductDTO.class);
		ProductDTO productResponse = response.getBody();

		System.out.println(response.getBody());

		return "Product is created with Id : " + productResponse.getProductId();
	}

	public List<ProductDTO> getAllProducts() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

		ResponseEntity<List> products = restTemplate.exchange(AppConstants.GET_ALL_PRODUCTS_URL, HttpMethod.GET,
				httpEntity, List.class);

		return products.getBody();
	}

	public ProductDTO updateProduct(ProductDTO product) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(product, headers);

		ResponseEntity<ProductDTO> productRes = restTemplate.exchange(AppConstants.UPDATE_PRODUCT_URL, HttpMethod.PUT,
				httpEntity, ProductDTO.class);

		return productRes.getBody();
	}

	public String deleteProductById(int id) {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

		ResponseEntity<String> response = restTemplate.exchange(AppConstants.DELETE_PRODUCT_URL + id, HttpMethod.DELETE,
				httpEntity, String.class);

		return response.getBody();
	}

	public ProductDTO findProductById(int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

		ResponseEntity<ProductDTO> response = restTemplate.exchange(AppConstants.FIND_PRODUCT_BY_ID_URL + id,
				HttpMethod.GET, httpEntity, ProductDTO.class);

		return response.getBody();
	}

}

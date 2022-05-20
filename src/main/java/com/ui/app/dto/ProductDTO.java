package com.ui.app.dto;

public class ProductDTO {
	
	private Integer productId;

	private String productName;

	private String productDesc;

	private String productCost;

	private int productCount;

	public ProductDTO() {

	}

	public ProductDTO(int productId, String productName, String productDesc, String productCost, int productCount) {
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productCost = productCost;
		this.productCount = productCount;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductCost() {
		return productCost;
	}

	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productCost=" + productCost + ", productCount=" + productCount + "]";
	}

}

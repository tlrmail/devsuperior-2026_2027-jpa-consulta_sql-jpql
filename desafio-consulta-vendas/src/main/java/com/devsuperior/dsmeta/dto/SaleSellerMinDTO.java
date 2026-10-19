package com.devsuperior.dsmeta.dto;

public class SaleSellerMinDTO {

	private String sellerName;
	private Double amount;
	
	public SaleSellerMinDTO() {
		// TODO Auto-generated constructor stub
	}

	public SaleSellerMinDTO(String sellerName, Double amount) {
		this.sellerName = sellerName;
		this.amount = amount;
	}

	public String getSellerName() {
		return sellerName;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "SaleSellerMinDTO [name=" + sellerName + ", amount=" + amount + "]";
	}
	
}

package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class SaleSellerDTO {

	private Long id;
	private Double amount;
	private LocalDate date;
	private String sellerName;
	
	public SaleSellerDTO() {
		// TODO Auto-generated constructor stub
	}

	public SaleSellerDTO(Long id, Double amount, LocalDate date, String sellerName) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.sellerName = sellerName;
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getSellerName() {
		return sellerName;
	}

	@Override
	public String toString() {
		return "SaleSellerDTO [id=" + id + ", amount=" + amount + ", date=" + date + ", sellerName=" + sellerName + "]";
	}

}

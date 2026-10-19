package com.devsuperior.uri2621.dtos;

import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductMinDTO {

	private String name;
	
	public ProductMinDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductMinDTO(String name) {
		this.name = name;
	}

	public ProductMinDTO(ProductMinProjection proj) {
		this.name = proj.getName();
	}

	public ProductMinDTO(Product entity) {
		this.name = entity.getName();
	}

	public String getName() {
		return name;
	}
	
	
}

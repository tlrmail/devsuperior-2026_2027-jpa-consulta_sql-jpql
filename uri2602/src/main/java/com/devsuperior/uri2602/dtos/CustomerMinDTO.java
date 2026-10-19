package com.devsuperior.uri2602.dtos;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerMinDTO {

	private String name;
	
	public CustomerMinDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerMinDTO(String name) {
		this.name = name;
	}

	public CustomerMinDTO(CustomerMinProjection entity) {
		this.name = entity.getName();
	}

	public String getName() {
		return name;
	}

}

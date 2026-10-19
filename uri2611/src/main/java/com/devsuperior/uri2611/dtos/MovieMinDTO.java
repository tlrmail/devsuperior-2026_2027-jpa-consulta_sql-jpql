package com.devsuperior.uri2611.dtos;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;

public class MovieMinDTO {

	private Long id;
	private String name;
	
	public MovieMinDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovieMinDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public MovieMinDTO(Movie entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public MovieMinDTO(MovieMinProjection proj) {
		this.id = proj.getId();
		this.name = proj.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MovieMinDTO [id=" + id + ", name=" + name + "]";
	}

}

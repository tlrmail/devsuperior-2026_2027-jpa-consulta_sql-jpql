package com.devsuperior.uri2611;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dtos.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> result1 = repository.search1("action");
		
		System.out.println("*** Resultado SQL ***");
		for(MovieMinProjection proj: result1) {
			MovieMinDTO dto = new MovieMinDTO(proj);
			System.out.println(dto);
		}
		
		List<MovieMinDTO> result2 = repository.search2("action");
		System.out.println("*** Resultado JPQL ***");
		for(MovieMinDTO dto: result2) {
			System.out.println(dto);
		}
		
	}
}

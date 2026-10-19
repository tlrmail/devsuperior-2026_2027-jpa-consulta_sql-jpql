package com.devsuperior.uri2609;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> list = repository.search1();
		System.out.println("*** Resultado SQL ***");
		for(CategorySumProjection proj: list) {
			CategorySumDTO dto = new CategorySumDTO(proj);
			System.out.println(dto);
		}
		
		List<CategorySumDTO> result = repository.search2();
		System.out.println("*** Resultado JPQL ***");
		for(CategorySumDTO dto: result) {
			System.out.println(dto);
		}
	}
}

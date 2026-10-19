package com.devsuperior.uri2621;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dtos.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductMinProjection> result1 = repository.search1(10, 20, "p");
		System.out.println("*** Resultado SQL ***");
		for(ProductMinProjection proj: result1) {
			ProductMinDTO dto = new ProductMinDTO(proj);
			System.out.println(dto.getName());
		}

		List<ProductMinDTO> result2 = repository.search2(10, 20, "p");
		System.out.println("*** Resultado JPQL ***");
		for(ProductMinDTO dto: result2) {
			System.out.println(dto.getName());
		}
}
}

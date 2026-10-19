package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dtos.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT p.name "
			+ "FROM products p "
			+ "INNER JOIN providers s ON p.id_providers = s.id "
			+ "WHERE p.amount BETWEEN :min AND :max "
			+ "AND UPPER(s.name) LIKE UPPER(CONCAT(:beginName,'%'))")
	List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

	@Query("SELECT new com.devsuperior.uri2621.dtos.ProductMinDTO(obj.name) "
			+ "FROM Product obj "
			+ "WHERE obj.amount BETWEEN :min AND :max "
			+ "AND UPPER(obj.provider.name) LIKE UPPER(CONCAT(:beginName,'%'))")
	List<ProductMinDTO> search2(Integer min, Integer max, String beginName);
}

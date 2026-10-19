package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SaleSellerDTO;
import com.devsuperior.dsmeta.dto.SaleSellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSellerMinDTO(obj.seller.name, SUM(obj.amount)) "
			+ "FROM Sale obj "
			+ "WHERE obj.date >=  :salesDate "
			+ "GROUP BY obj.seller.name")
	Page<SaleSellerMinDTO> searchSummaryJPQL(LocalDate salesDate, Pageable pageable);

	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSellerMinDTO(obj.seller.name, SUM(obj.amount)) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :min AND :max "
			+ "GROUP BY obj.seller.name")
	Page<SaleSellerMinDTO> searchSummaryBetweenDatesJPQL(LocalDate min, LocalDate max, Pageable pageable);

	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSellerDTO(obj.id, obj.amount, obj.date ,obj.seller.name) "
			+ "FROM Sale obj "
			+ "WHERE obj.date >=  :salesDate "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%',:name,'%')) ")
	Page<SaleSellerDTO> searchReportJPQL(LocalDate salesDate, String name, Pageable pageable);

	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSellerDTO(obj.id, obj.amount, obj.date ,obj.seller.name) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :min AND :max "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%',:name,'%')) ")
	Page<SaleSellerDTO> searchReportBetweenDatesJPQL(LocalDate min, LocalDate max, String name, Pageable pageable);

}

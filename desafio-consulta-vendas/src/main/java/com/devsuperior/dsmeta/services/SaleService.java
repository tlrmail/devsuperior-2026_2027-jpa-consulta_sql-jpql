package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSellerDTO;
import com.devsuperior.dsmeta.dto.SaleSellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<SaleSellerMinDTO> getSummaryBetweenDates(String minDate, String maxDate, Pageable pageable){
		Page<SaleSellerMinDTO> dtos; 
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate dataDeUmAnoAtras = today.minusYears(1L);
		
		if(minDate == null && maxDate == null) {
			dtos = repository.searchSummaryJPQL(dataDeUmAnoAtras, pageable);
		}else if(minDate != null && maxDate == null) {
			LocalDate min = LocalDate.parse(minDate);
			dtos = repository.searchSummaryJPQL(min, pageable);
		}else if((minDate == null && maxDate != null) || maxDate.isEmpty()){
			dtos = repository.searchSummaryJPQL(today, pageable);
		}else if(minDate.isEmpty()){
			dtos = repository.searchSummaryBetweenDatesJPQL(dataDeUmAnoAtras, today, pageable);
		}else{ 
			LocalDate min = LocalDate.parse(minDate);
			LocalDate max = LocalDate.parse(maxDate);
			dtos = repository.searchSummaryBetweenDatesJPQL(min, max, pageable);
		}
		return dtos;
	}

	@Transactional(readOnly = true)
	public Page<SaleSellerDTO> getReportBetweenDates(String minDate, String maxDate, String name, Pageable pageable) {

		Page<SaleSellerDTO> dtos; 
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate dataDeUmAnoAtras = today.minusYears(1L);
		String strName = (name == null)? "": name;
		
		if(minDate == null && maxDate == null) {
			dtos = repository.searchReportJPQL(dataDeUmAnoAtras, strName, pageable);
		}else if(minDate != null && maxDate == null) {
			LocalDate min = LocalDate.parse(minDate);
			dtos = repository.searchReportJPQL(min, strName, pageable);
		}else if((minDate == null && maxDate != null) || maxDate.isEmpty()){
			dtos = repository.searchReportJPQL(today, strName, pageable);
		}else if(minDate.isEmpty()){
			dtos = repository.searchReportBetweenDatesJPQL(dataDeUmAnoAtras, today, strName, pageable);
		}else{ 
			LocalDate min = LocalDate.parse(minDate);
			LocalDate max = LocalDate.parse(maxDate);
			dtos = repository.searchReportBetweenDatesJPQL(min, max, strName, pageable);
		}

		return dtos;
	}

}

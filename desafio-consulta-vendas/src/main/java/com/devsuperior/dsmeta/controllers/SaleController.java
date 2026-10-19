package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.DsmetaApplication;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSellerDTO;
import com.devsuperior.dsmeta.dto.SaleSellerMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	private final DsmetaApplication dsmetaApplication;
	@Autowired
	private SaleService service;

	SaleController(DsmetaApplication dsmetaApplication) {
		this.dsmetaApplication = dsmetaApplication;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleSellerDTO>> getReport(
			@RequestParam(required = false) String minDate, @RequestParam(required = false) String maxDate, 
			@RequestParam(required = false, defaultValue = "") String name, Pageable pageable) {
		Page<SaleSellerDTO> dtos = service.getReportBetweenDates(minDate, maxDate, name, pageable); 
		return ResponseEntity.ok(dtos);
	}


	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleSellerMinDTO>> getSummary(
			@RequestParam(required = false) String minDate, @RequestParam(required = false) String maxDate,
			Pageable pageable) {
		Page<SaleSellerMinDTO> dtos = service.getSummaryBetweenDates(minDate, maxDate, pageable);
		return ResponseEntity.ok(dtos);
	}

}

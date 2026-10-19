package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dtos.PersonDTO;
import com.devsuperior.aula.dtos.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());

		//		Department department = new Department();
		//		department.setId(dto.getDepartment().getId());
		
		entity.setDepartment(department);
		
		entity = repository.save(entity);
		
		dto = new PersonDepartmentDTO(entity);
		
		return dto;
	}
	
	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department department = departmentRepository.getReferenceById(dto.getDepartmentId());

		//		Department department = new Department();
		//		department.setId(dto.getDepartment().getId());
		
		entity.setDepartment(department);
		
		entity = repository.save(entity);
		
		dto = new PersonDTO(entity);
		
		return dto;
	}
	
}

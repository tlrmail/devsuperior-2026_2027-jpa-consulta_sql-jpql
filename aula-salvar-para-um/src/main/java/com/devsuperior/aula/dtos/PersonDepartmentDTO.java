package com.devsuperior.aula.dtos;

import com.devsuperior.aula.entities.Person;

public class PersonDepartmentDTO {

	private Long id;
	private String name;
	private Double salary;
	
	private DepartmentDTO department;
		
	public PersonDepartmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO departmentDTO) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = departmentDTO;
	}

	public PersonDepartmentDTO(Person entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.salary = entity.getSalary();
		this.department = new DepartmentDTO(entity.getDepartment());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}
	
}

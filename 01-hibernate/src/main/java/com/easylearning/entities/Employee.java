package com.easylearning.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private Long id;
	
	private String name;
	
	private Double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Employee(Long id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
	
	

}

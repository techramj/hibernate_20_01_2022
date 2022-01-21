package com.easylearning.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empGenerator")
	@SequenceGenerator(name = "empGenerator", sequenceName = "seq_emp_id1", allocationSize = 1, initialValue = 100)
	private Long id;
	
	private String name;
	
	private Double salary;
	
	@Column(name="DATE_OF_JOINING")
	private Date dateOfJoining;
	
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

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	
	
	
	
	
	

}

package com.easylearning.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="dept123")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deptGenerator")
	@SequenceGenerator(name = "deptGenerator", sequenceName = "seq_dept_id1", initialValue = 100, allocationSize = 10)
	private Long did;
	
	@Column(name="DNAME")
	private String departmentName;
	
	public Department() {
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

}

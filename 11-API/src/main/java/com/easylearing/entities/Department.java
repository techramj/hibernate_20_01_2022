package com.easylearing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	@SequenceGenerator(name = "dept_seq", sequenceName = "SEQ_DEPT_ID")
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee Manager;
	

	@ManyToOne
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Employee getManager() {
		return Manager;
	}

	public void setManager(Employee manager) {
		Manager = manager;
	}
	
	
	
	

}

package com.empdetail.employeemanagement.model;

import jakarta.persistence.*;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dept;
	private String deptName;

//	public Department(String deptName) {
//		super();
//		this.deptName = deptName;
//	}
	public Long getId_dept() {
		return id_dept;
	}

	public void setId_dept(Long id_dept) {
		this.id_dept = id_dept;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

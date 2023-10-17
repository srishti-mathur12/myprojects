package com.empdetail.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.empdetail.employeemanagement.model.Department;
import com.empdetail.employeemanagement.service.DepartmentService;

public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/")
	public ResponseEntity<List<Department>> getAllDepartment(){
		return ResponseEntity.ok(departmentService.findAllDepartment());
	}
	
	
	@GetMapping("/id-department")
	public ResponseEntity<Department> getDepartmentById(Long id){
		return ResponseEntity.ok(departmentService.findDepartmentById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> getAllDepartment(@PathVariable Long id,@RequestBody Department department){
		departmentService.deleteDepartment(department);
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/")
	public ResponseEntity<Boolean> addDepartment(@RequestBody Department department){
		departmentService.addNewDepartment(department);
		return ResponseEntity.ok(true);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> upadateDepartment(@PathVariable Long id,@RequestBody Department department){
		 departmentService.updateSpecificDepartment(department);
		 return ResponseEntity.ok(true);
	}
	



}

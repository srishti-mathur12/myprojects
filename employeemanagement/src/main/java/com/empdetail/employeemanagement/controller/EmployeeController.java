package com.empdetail.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/home")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(employeeService.findAllEmployees());
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.findEmployeeById(id));
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Boolean> getAllEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok(true);
	}

	@PostMapping("/employee")
	public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
		return ResponseEntity.ok(true);
	}

	@PutMapping("/employee")
	public ResponseEntity<Boolean> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employeeService.updateSpecificEmployee(id, employee);
		return ResponseEntity.ok(true);
	}

}

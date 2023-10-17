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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/home")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.findAllEmployees());
	}
	
//	@GetMapping("/department")
//	public ResponseEntity <List<Employee>> getByEmployeeDepartment(Employee employee){
//		return ResponseEntity.ok(employeeService.findEmployeesByDepartment());
//	}
	
	@GetMapping("/id-employee")
	public ResponseEntity<Employee> getEmployeeById(Long id){
		return ResponseEntity.ok(employeeService.findEmployeeById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> getAllEmployee(@PathVariable Long id,@RequestBody Employee employee){
		employeeService.deleteEmployee(employee);
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/")
	public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee){
		employeeService.addNewEmployee(employee);
		return ResponseEntity.ok(true);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> upadateEmployee(@PathVariable Long id,@RequestBody Employee employee){
		employeeService.updateSpecificEmployee(employee);
		return ResponseEntity.ok(true);
	}
	


}

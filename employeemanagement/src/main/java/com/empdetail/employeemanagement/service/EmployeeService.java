package com.empdetail.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return (employeeRepository.findAll());
    }

    public Page<Employee> getEmployeeByPaginate(int currentPage, int size) {
        PageRequest p = PageRequest.of(currentPage, size);
        return employeeRepository.findAll(p);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    public Employee updateSpecificEmployee(Long id, Employee employee) {
        Employee emp = employeeRepository.getById(id);
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setAddress(employee.getAddress());
        emp.setSalary(employee.getSalary());
        emp.setContactNumber(employee.getContactNumber());
        return employeeRepository.save(emp);
    }

	public Page<Employee> findEmployeeByName(String name, int currentPage, int size) {
		PageRequest p = PageRequest.of(currentPage, size);
		Page<Employee> employees = employeeRepository.findByName(name, p);
		return employees;
	}


}

package  com.empdetail.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployees(){
		return (employeeRepository.findAll());
	}
//	public List<Employee>  findEmployeesByDepartment(){
//		return (employeeRepository.findByDepartment());
//	}
//	
	 public void deleteEmployee(Employee employee) { 
	        employeeRepository.delete(employee); 
	    } 
	 public Employee addNewEmployee(Employee employee) { 
	        return employeeRepository.save(employee); 
	    }
	 
	 public Employee findEmployeeById(Long id) { 
	        return employeeRepository.getById(id); 
	    } 
	 public Employee updateSpecificEmployee(Employee employee) { 
	        return employeeRepository.save(employee); 
	    }
	      

}

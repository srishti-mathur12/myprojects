package  com.empdetail.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.empdetail.employeemanagement.model.Department;
import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.repository.DepartmentRepository;


@Service
public class DepartmentService {

	@Autowired DepartmentRepository departmentRepository;
	
	public List<Department> findAllDepartment(){
		return (departmentRepository.findAll());
	}
	 public void addNewDepartment(Department department) { 
	          departmentRepository.save(department); 
	    }
	 
	 public Department findDepartmentById(Long id) { 
	        return departmentRepository.getById(id); 
	    } 
	 public void updateSpecificDepartment(Department department) { 
	         departmentRepository.save(department); 
	    }
	 public void deleteDepartment(Department department) { 
	        departmentRepository.delete(department); 
	    }
	      
	
}

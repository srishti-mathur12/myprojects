package com.empdetail.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empdetail.employeemanagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{


}

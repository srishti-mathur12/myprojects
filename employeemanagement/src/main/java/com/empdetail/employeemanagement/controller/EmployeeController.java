package com.empdetail.employeemanagement.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/home")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model m) {
        return findPaginated(0, m);
    }

    @GetMapping("/page/{pageno}")
    public String findPaginated(@PathVariable int pageno, Model m) {

        Page<Employee> emplist = employeeService.getEMpByPaginate(pageno, 10);
        m.addAttribute("employee", emplist);
        m.addAttribute("currentPage", pageno);
        m.addAttribute("totalPages", emplist.getTotalPages());
        m.addAttribute("totalItem", emplist.getTotalElements());
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm() {
        return "add-emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session) {
        employeeService.addNewEmployee(e);
        session.setAttribute("msg", "Emplyoee Added Sucessfully..");
        return "redirect:/home/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model m) {
        Employee e = employeeService.findEmployeeById(id);
        m.addAttribute("employee", e);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
        employeeService.addNewEmployee(e);
        session.setAttribute("msg", "Emp Data Update Sucessfully..");
        return "redirect:/home/";
    }

    /* Delete employee */
    @DeleteMapping("/delete/{id}")
    public String deleteEMp(@PathVariable Long id, HttpSession session) {
        employeeService.deleteEmployee(id);
        session.setAttribute("msg", "Emp Data Delete Sucessfully..");
        return "redirect:/home/";
    }

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

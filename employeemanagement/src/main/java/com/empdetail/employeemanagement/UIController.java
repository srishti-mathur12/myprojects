package com.empdetail.employeemanagement;

import com.empdetail.employeemanagement.model.Employee;
import com.empdetail.employeemanagement.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class UIController {
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
    @GetMapping("/delete/{id}")
    public String deleteEMp(@PathVariable Long id, HttpSession session) {
        employeeService.deleteEmployee(id);
        session.setAttribute("msg", "Emp Data Delete Sucessfully..");
        return "redirect:/home/";
    }
}

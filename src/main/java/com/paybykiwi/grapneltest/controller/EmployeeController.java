package com.paybykiwi.grapneltest.controller;


import com.paybykiwi.grapneltest.model.Employee;
import com.paybykiwi.grapneltest.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/traditional")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {

        return employeeService.get(id);

    }

    @GetMapping("/employee/all")
    public List<Employee> getEmployee() {

        return employeeService.getAll();

    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.create(employee);

    }
}

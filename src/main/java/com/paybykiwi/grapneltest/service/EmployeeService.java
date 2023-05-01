package com.paybykiwi.grapneltest.service;

import com.paybykiwi.grapneltest.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

//    public Optional<Employee> getEmployee(long id);
//
//    public Employee addEmployee(Employee employee);
//
//    List<Employee> getAllEmployee();
//



    //create
    Employee create(Employee employee);

    //get all
    List<Employee> getAll();

    //get single book
    Employee get(int employeeId);

}

package com.narayan.graphqltest.service;

import com.narayan.graphqltest.model.Employee;
import com.narayan.graphqltest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee create(Employee employee) {
        System.out.println("Employee "+employee.toString());

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(int employeeId) {
        return this.employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee you are looking for not found on server !!"));
    }


//    @Override
//    public Optional<Employee> getEmployee(long id) {
//        return employeeRepository.findById(id);
//    }
//
//    @Override
//    public Employee addEmployee(Employee employee) {
//
//        return employeeRepository.save(employee);
//    }
//
//    @Override
//    public List<Employee> getAllEmployee() {
//        return employeeRepository.findAll();
//    }


}

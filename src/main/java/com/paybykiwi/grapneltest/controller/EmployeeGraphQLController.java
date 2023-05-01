package com.paybykiwi.grapneltest.controller;


import com.paybykiwi.grapneltest.model.Employee;
import com.paybykiwi.grapneltest.service.EmployeeService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeGraphQLController {


    @Autowired
    private EmployeeService employeeService;

    @MutationMapping("createEmployee")
    public Employee create(@Argument EmployeeInput employeeInput) {

        Employee employee=new Employee();
        employee.setName(employeeInput.getName());
        employee.setDesignation(employeeInput.getDesignation());

        return employeeService.create(employee);
    }


    @QueryMapping("employeeById")
    public Employee getEmployeeById(@Argument int employeeId) {

        System.out.println("ID "+employeeId);
        return this.employeeService.get(employeeId);
    }



    @QueryMapping("allEmployee")
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }

}



@Data
class EmployeeInput{
    private String name;
    private String designation;
}

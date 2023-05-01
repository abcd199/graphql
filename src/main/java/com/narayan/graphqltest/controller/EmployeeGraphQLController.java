package com.narayan.graphqltest.controller;


import com.narayan.graphqltest.model.Employee;
import com.narayan.graphqltest.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

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

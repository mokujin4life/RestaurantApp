package com.mokujin.controller;

import com.mokujin.models.employee.Employee;
import com.mokujin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Danil on 06.12.16.
 */
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {
        model.put("employees", employeeService.getAll());
        return "employees";
    }

    @RequestMapping(value = "/employee_adding", method = RequestMethod.GET)
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              BindingResult result) {

        employeeService.add(employee);

        return "employee_adding";
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}

package com.mokujin.controller;

import com.mokujin.models.employee.Employee;
import com.mokujin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private int id = 0;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> map) {

        map.put("employee", new Employee());
        map.put("employees", employeeService.getAll());

        return "employee";
    }


    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              BindingResult result) {


        employee.setId(id);
        id++;
        employeeService.add(employee);

        return "redirect:/employees";
    }

    /*@RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        employeeService.delete(contactId);

        return "redirect:/index";*/

    @RequestMapping(value = "/delete_employee/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Integer id) {

        employeeService.delete(id);

        return "redirect:/employees";
    }
}

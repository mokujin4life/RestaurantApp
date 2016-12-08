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

/**
 * Created by Danil on 07.12.16.
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String employees(Map<String, Object> map) {

        map.put("employee", new Employee());
        map.put("employees", employeeService.getAll());

        return "employee";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              BindingResult result) {

        employeeService.add(employee);

        return "redirect:/index";
    }

    /*@RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        employeeService.delete(contactId);

        return "redirect:/index";
    }*/
}

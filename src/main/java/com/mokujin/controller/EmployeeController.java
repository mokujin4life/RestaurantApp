package com.mokujin.controller;

import com.mokujin.model.employee.Employee;
import com.mokujin.service.EmployeeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> map) {

        map.put("employees", employeeService.getAll());


        return "employee";
    }


    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              BindingResult result) {

        employeeService.add(employee);

        return "redirect:/employees";
    }


    @RequestMapping(value = "/delete_employee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Integer id) {

        employeeService.delete(id);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee_save_image/{id}", method = RequestMethod.POST)
    public String saveImage(@PathVariable("id") Integer id,
                            @ModelAttribute("file") MultipartFile file) {
        try {
            Employee employee = employeeService.get(id);
            byte[] photo = IOUtils.toByteArray(file.getInputStream());
            employee.setPhoto(photo);
            employeeService.edit(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/employees";
    }
}

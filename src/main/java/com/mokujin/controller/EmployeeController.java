package com.mokujin.controller;

import com.mokujin.model.employee.Employee;
import com.mokujin.service.EmployeeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> map) {

        map.put("employees", employeeService.getAll());


        return "employee";
    }


    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              @ModelAttribute("file") MultipartFile file) {

        if (file != null) {
            employee.setPhoto(convertFileToByteArray(employee, file));
        }
        employeeService.add(employee);
        return "redirect:/employees";
    }


    @RequestMapping(value = "/delete_employee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Integer id) {

        employeeService.delete(id);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/edit_employee/{id}", method = RequestMethod.GET)
    public String editEmployee(@PathVariable("id") Integer id, Map<String, Object> map) {

        Employee employee = employeeService.get(id);
        map.put("employee", employee);

        return "employee-config";
    }

    @RequestMapping(value = "/update_employee/{id}", method = RequestMethod.POST)
    public String updateEditedEmployee(@ModelAttribute("employee") Employee employee,
                                       @ModelAttribute("file") MultipartFile file,
                                       @PathVariable("id") Integer id) {
        Employee existingEmployee = employeeService.get(id);
        if (!Objects.equals(employee.getName(), "")) {
            existingEmployee.setName(employee.getName());
        }
        if (!Objects.equals(employee.getPhone(), "")) {
            existingEmployee.setPhone(employee.getPhone());
        }
        if (file != null) {
            existingEmployee.setPhoto(convertFileToByteArray(employee, file));
        }
        employeeService.edit(existingEmployee);
        return "redirect:/employees";
    }

    private byte[] convertFileToByteArray(@ModelAttribute("employee") Employee employee,
                                          @ModelAttribute("file") MultipartFile file) {
        byte[] photo = null;
        try {
            photo = IOUtils.toByteArray(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photo;
    }
}

package com.mokujin.controller;

import com.mokujin.models.employee.Employee;
import com.mokujin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mokujin on 12/12/16.
 */
@Controller
@RequestMapping("/img")
public class ImageController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Integer id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {


        Employee employee = employeeService.get(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(employee.getPhoto());
        response.getOutputStream().close();
    }
}
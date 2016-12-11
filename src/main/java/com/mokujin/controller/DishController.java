package com.mokujin.controller;

import com.mokujin.models.dish.Dish;
import com.mokujin.models.employee.Employee;
import com.mokujin.service.DishService;
import com.mokujin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class DishController {
    private DishService dishService;

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String dishes(Map<String, Object> map) {

        map.put("dish", new Dish());
        map.put("dishes", dishService.getAll());

        return "dish";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") Dish dish,
                          BindingResult result) {

        dishService.add(dish);

        return "redirect:/dishes";
    }

    /*@RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        employeeService.delete(contactId);

        return "redirect:/index";
    }*/
}

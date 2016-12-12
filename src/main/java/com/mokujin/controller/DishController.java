package com.mokujin.controller;

import com.mokujin.model.dish.Dish;
import com.mokujin.model.employee.Employee;
import com.mokujin.service.DishService;
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
import java.util.Objects;

@Controller
public class DishController {
    @Autowired
    private DishService dishService;


    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String dishes(Map<String, Object> map) {

        map.put("dishes", dishService.getAll());


        return "dish";
    }


    @RequestMapping(value = "/add_dish", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") Dish dish,
                              @ModelAttribute("file") MultipartFile file) {

        if (file != null) {
            dish.setPhoto(convertFileToByteArray(dish, file));
        }
        dishService.add(dish);
        return "redirect:/dishes";
    }


    @RequestMapping(value = "/delete_dish/{id}", method = RequestMethod.GET)
    public String deleteDish(@PathVariable("id") Integer id) {

        dishService.delete(id);

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/edit_dish/{id}", method = RequestMethod.GET)
    public String editDish(@PathVariable("id") Integer id, Map<String, Object> map) {

        Dish dish = dishService.get(id);
        map.put("dish", dish);

        return "dish-config";
    }

    @RequestMapping(value = "/update_dish/{id}", method = RequestMethod.POST)
    public String updateEditedEmployee(@ModelAttribute("dish") Dish dish,
                                       @ModelAttribute("file") MultipartFile file,
                                       @PathVariable("id") Integer id) {
        Dish existingDish = dishService.get(id);
        if (!Objects.equals(dish.getName(), "")) {
            existingDish.setName(dish.getName());
        }
        if (!Objects.equals(dish.getPrice(), "")) {
            existingDish.setPrice(dish.getPrice());
        }
        if (!Objects.equals(dish.getWeight(), "")) {
            existingDish.setWeight(dish.getWeight());
        }
        if (file != null) {
            existingDish.setPhoto(convertFileToByteArray(dish, file));
        }
        dishService.edit(existingDish);
        return "redirect:/dishes";
    }

    private byte[] convertFileToByteArray(@ModelAttribute("dish") Dish dish,
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

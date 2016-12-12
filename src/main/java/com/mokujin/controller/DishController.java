package com.mokujin.controller;

import com.mokujin.model.dish.Dish;
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
                              BindingResult result) {

        dishService.add(dish);

        return "redirect:/dishes";
    }


    @RequestMapping(value = "/delete_dish/{id}", method = RequestMethod.GET)
    public String deleteDish(@PathVariable("id") Integer id) {

        dishService.delete(id);

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/dish_save_image/{id}", method = RequestMethod.POST)
    public String saveImage(@PathVariable("id") Integer id,
                       @ModelAttribute("file") MultipartFile file) {
        if (null != file) {
            try {
                Dish dish = dishService.get(id);
                byte[] photo = IOUtils.toByteArray(file.getInputStream());
                dish.setPhoto(photo);
                dishService.edit(dish);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/dishes";
    }
}

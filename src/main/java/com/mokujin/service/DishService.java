package com.mokujin.service;

import com.mokujin.dao.dish.DishDAO;
import com.mokujin.dao.dish.IDishDAO;
import com.mokujin.models.dish.Dish;

import java.util.List;

public class DishService {

    DishDAO dishDAO = new IDishDAO();

    public void add(Dish dish) {
        boolean ingredientAppearance = validateIngredientAppearance(dish);
        boolean dishValidation = validateObject(dish);
        if (ingredientAppearance && dishValidation) {
            dishDAO.add(dish);
        }
    }

    public void get(Integer id) {
        if (validateId(id)) {
            dishDAO.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    private boolean validateId(Integer id) {
        return id < dishDAO.getAll().size() && id > 0;
    }

    public List<Dish> getAll() {
        return dishDAO.getAll();
    }

    public void delete(Dish dish) {
        dishDAO.delete(dish);
    }

    public void edit(Dish dish) {
        dishDAO.edit(dish);
    }

    private boolean validateIngredientAppearance(Dish dish) {
        return dish.getIngredients().size() > 0;
    }

    private boolean validateObject(Dish dish) {
        return dish != null;
    }
}

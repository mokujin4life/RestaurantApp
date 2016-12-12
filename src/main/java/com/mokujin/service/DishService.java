package com.mokujin.service;

import com.mokujin.dao.dish.DishDAO;
import com.mokujin.dao.dish.IDishDAO;
import com.mokujin.model.dish.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DishService {

    @Autowired
    DishDAO dishDAO;

    public void add(Dish dish) {
        /*boolean ingredientAppearance = validateIngredientAppearance(dish);
        boolean dishValidation = validateObject(dish);
        if (ingredientAppearance && dishValidation) {
            dishDAO.add(dish);
        }*/
        dishDAO.add(dish);
    }

    public Dish get(int id) {
        /*if (validateId(id)) {
            dishDAO.get(id);
        } else {
            throw new RuntimeException();
        }*/
        return dishDAO.get(id);
    }



    public List<Dish> getAll() {
        return dishDAO.getAll();
    }

    public void delete(Integer id) {
        dishDAO.delete(id);
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

    private boolean validateId(Integer id) {
        return id < dishDAO.getAll().size() && id > 0;
    }
}

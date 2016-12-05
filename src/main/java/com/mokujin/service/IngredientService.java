package com.mokujin.service;

import com.mokujin.dao.ingredient.IIngredientDAO;
import com.mokujin.dao.ingredient.IngredientDAO;
import com.mokujin.models.dish.Dish;
import com.mokujin.models.ingredient.Ingredient;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class IngredientService {

    IngredientDAO ingredientDAO = new IIngredientDAO();

    public void add(Ingredient ingredient) {
        ingredientDAO.add(ingredient);
    }

    public void get(Integer id) {
        if (id < ingredientDAO.getAll().size()) {
            ingredientDAO.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Ingredient> getAll() {
        return ingredientDAO.getAll();
    }

    public void delete(Ingredient ingredient) {
        ingredientDAO.delete(ingredient);
    }

    public void edit(Ingredient ingredient){
        ingredientDAO.edit(ingredient);
    }

}

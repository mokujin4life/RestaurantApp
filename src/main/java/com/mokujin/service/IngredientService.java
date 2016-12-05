package com.mokujin.service;

import com.mokujin.dao.ingredient.IIngredientDAO;
import com.mokujin.dao.ingredient.IngredientDAO;
import com.mokujin.models.ingredient.Ingredient;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class IngredientService {

    IngredientDAO ingredientDAO = new IIngredientDAO();

    public void add(Ingredient ingredient) {
        boolean ingredientValidation = validateObject(ingredient);
        if (ingredientValidation) {
            ingredientDAO.add(ingredient);
        }
    }

    public void get(Integer id) {
        if (validateId(id)) {
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

    public void edit(Ingredient ingredient) {
        ingredientDAO.edit(ingredient);
    }


    private boolean validateObject(Ingredient ingredient) {
        return ingredient != null;
    }

    private boolean validateId(Integer id) {
        return id < ingredientDAO.getAll().size() && id > 0;
    }

}

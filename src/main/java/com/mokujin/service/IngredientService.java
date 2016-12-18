package com.mokujin.service;

import com.mokujin.dao.ingredient.IngredientDAO;
import com.mokujin.model.ingredient.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientService {

    @Autowired
    IngredientDAO ingredientDAO;

    public void add(Ingredient ingredient) {
       /* boolean ingredientValidation = validateObject(ingredient);
        if (ingredientValidation) {
            ingredientDAO.add(ingredient);
        }*/
        ingredientDAO.add(ingredient);

    }

    public Ingredient get(Integer id) {
       /* if (validateId(id)) {
            ingredientDAO.get(id);
        } else {
            throw new RuntimeException();
        }*/
        return ingredientDAO.get(id);
    }

    public List<Ingredient> getAll() {
        return ingredientDAO.getAll();
    }

    public void delete(Integer id) {
        ingredientDAO.delete(id);
    }

    public void edit(Ingredient ingredient) {
        ingredientDAO.edit(ingredient);
    }


    /*private boolean validateObject(Ingredient ingredient) {
        return ingredient != null;
    }

    private boolean validateId(Integer id) {
        return id < ingredientDAO.getAll().size() && id > 0;
    }
*/
}

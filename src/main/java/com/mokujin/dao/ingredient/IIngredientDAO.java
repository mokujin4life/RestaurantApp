package com.mokujin.dao.ingredient;

import com.mokujin.models.employee.Employee;
import com.mokujin.models.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class IIngredientDAO implements IngredientDAO {
    List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public List<Ingredient> getAll() {
        return ingredients;
    }

    @Override
    public Ingredient get(Integer id) {
        try {
            return ingredients.get(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void add(Ingredient ingredient) {
        ingredients.add(ingredient);
        getAll().forEach(item -> System.out.println(item));
    }

    @Override
    public void delete(Ingredient ingredient) {
        try {
            ingredients.remove(ingredient);
        } catch (Exception e) {
            throw new RuntimeException("no object=" + ingredient + " found");
        }

    }

    @Override
    public void edit(Ingredient ingredient) {
        try {
            ingredients.remove(ingredient.getId());
            ingredients.add(ingredient.getId(), ingredient);
        } catch (Exception e) {
            throw new RuntimeException("no object=" + ingredient + " found");
        }
    }
}

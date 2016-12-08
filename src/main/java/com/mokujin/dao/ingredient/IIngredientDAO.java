package com.mokujin.dao.ingredient;

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
        getAll().forEach(System.out::println);
    }

    @Override
    public void delete(Integer id) {
        try {
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getId() == id) {
                    ingredients.remove(ingredient);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("no object with id=" + id + " found");
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

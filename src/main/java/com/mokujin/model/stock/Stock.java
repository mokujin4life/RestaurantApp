package com.mokujin.model.stock;

import com.mokujin.model.ingredient.Ingredient;

import java.util.HashMap;
import java.util.Map;


public class Stock {

    private Map<Ingredient, Integer> availableIngredients = new HashMap<>();

    public Map<Ingredient, Integer> getAvailableIngredients() {
        return availableIngredients;
    }

    public void addNewIngredient(Ingredient ingredient, Integer ingredientsQuantity) {
        availableIngredients.put(ingredient, ingredientsQuantity);
    }
}

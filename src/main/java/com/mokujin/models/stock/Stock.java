package com.mokujin.models.stock;

import com.mokujin.models.ingredient.Ingredient;

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

package com.mokujin.models.stock;

import com.mokujin.models.ingredient.Ingredient;

import java.util.Map;


public class Stock {

    private Map<Ingredient, Integer> availableIngredients;

    public Map<Ingredient, Integer> getAvailableIngredients() {
        return availableIngredients;
    }

    public void addNewIngredient(Ingredient ingredient, Integer ingredientsQuatity) {
    }
}

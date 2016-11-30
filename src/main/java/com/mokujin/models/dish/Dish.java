package com.mokujin.models.dish;

import com.mokujin.models.ingredient.Ingredient;

import java.util.List;


public class Dish {

    private String name;

    private int weight;

    private int price;

    private List<Ingredient> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addNewIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}

package com.mokujin.model.stock;

import com.mokujin.model.ingredient.Ingredient;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "stock")
public class StockIngredient {

    @Id
    @OneToOne
    @JoinColumn(name="id", unique=true, nullable=false, updatable=false)
    private Ingredient ingredient;

    @Column(name = "quantiy")
    private double quantity;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    /* @ElementCollection()
    @CollectionTable(name = "ingredient",
            joinColumns = @JoinColumn(name = "id"))
    @MapKeyJoinColumn(name = "D_ID")
    @Column(name = "quantity")
    private Map<Ingredient, Integer> availableIngredients = new HashMap<>();

    public Map<Ingredient, Integer> getAvailableIngredients() {
        return availableIngredients;
    }

    public void addNewIngredient(Ingredient ingredient, Integer ingredientsQuantity) {
        availableIngredients.put(ingredient, ingredientsQuantity);
    }*/
}

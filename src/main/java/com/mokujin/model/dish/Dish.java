package com.mokujin.model.dish;

import com.mokujin.model.ingredient.Ingredient;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "weight")
    private int weight;

    @Column(name = "price")
    private int price;

    @Column(name = "photo")
    private byte[] photo;

    @ElementCollection
    @CollectionTable(name="ingredient", joinColumns=@JoinColumn(name="dish_id"))
    @Column(name="ingredient_name")
    private List<Ingredient> ingredients;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}

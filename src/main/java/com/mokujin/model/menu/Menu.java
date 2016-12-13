package com.mokujin.model.menu;

import com.mokujin.model.dish.Dish;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(name="dish", joinColumns=@JoinColumn(name="id"))
    @Column(name="dish_name")
    private List<Dish> dishList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public void addNewDish(Dish dish) {
        dishList.add(dish);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dishList=" + dishList +
                '}';
    }
}

package com.mokujin.models.menu;

import com.mokujin.models.dish.Dish;

import java.util.List;

public class Menu {

    private String name;

    private List<Dish> dishList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

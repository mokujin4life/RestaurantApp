package com.mokujin.models.order;


import com.mokujin.models.dish.Dish;
import com.mokujin.models.employee.Waiter;
import sun.util.calendar.BaseCalendar.Date;

import java.util.List;

public class Order {

    private Date date;

    private Waiter waiter;

    private int tableNumber;

    private List<Dish> orderedDishes;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public void addNewDish(Dish dish) {
        orderedDishes.add(dish);
    }
}

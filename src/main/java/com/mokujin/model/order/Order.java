package com.mokujin.model.order;


import com.mokujin.model.dish.Dish;
import com.mokujin.model.employee.Waiter;
import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private GregorianCalendar date;

    @JoinColumn(name = "id")
    private Waiter waiter;

    @Column(name = "table_number")
    private int tableNumber;

    @ElementCollection
    @CollectionTable(name="dish", joinColumns=@JoinColumn(name="id"))
    @Column(name="dish_name")
    private List<Dish> orderedDishes;

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", waiter=" + waiter +
                ", tableNumber=" + tableNumber +
                ", orderedDishes=" + orderedDishes +
                '}';
    }

}

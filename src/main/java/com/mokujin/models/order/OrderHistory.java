package com.mokujin.models.order;

import java.util.List;

public class OrderHistory {
    private List<Order> orderList;

    public List<Order> filterByDate() {
        return null;
    }

    public List<Order> filterByWaiter() {
        return null;
    }

    public List<Order> filterByTableNumber() {
        return null;
    }

    public List<Order> getOrders() {
        return orderList;
    }

    public void addNewOrder(Order order) {
        orderList.add(order);
    }
}

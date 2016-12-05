package com.mokujin.models.order;

import java.util.List;

public class OrderHistory {
    private List<Order> orderList;

    public List<Order> getOrders() {
        return orderList;
    }

    public void addNewOrder(Order order) {
        orderList.add(order);
    }
}

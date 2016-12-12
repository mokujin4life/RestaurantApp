package com.mokujin.service;


import com.mokujin.dao.order.history.IOrderHistoryDAO;
import com.mokujin.dao.order.history.OrderHistoryDAO;
import com.mokujin.model.employee.Waiter;
import com.mokujin.model.order.Order;
import com.mokujin.model.order.OrderHistory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistoryService {
    OrderHistoryDAO orderHistoryDAO = new IOrderHistoryDAO();

    public List<Order> getOrders() {
        return orderHistoryDAO.getOrdersHistory().getOrders();
    }


    public void setOrder(Order order) {
        System.out.println("gere");
        if (validateOrder(order)) {
            OrderHistory orderHistory = orderHistoryDAO.getOrdersHistory();
            System.out.println(orderHistoryDAO.getOrdersHistory());
            orderHistory.addNewOrder(order);
            orderHistoryDAO.updateOrdersHistory(orderHistory);
            getOrders().forEach(System.out::println);
        }
    }


    public void deleteOrder(Order order) {
        try {
            OrderHistory ordersHistory = orderHistoryDAO.getOrdersHistory();
            ordersHistory.getOrders().remove(order);
            orderHistoryDAO.updateOrdersHistory(ordersHistory);
        } catch (Exception e) {
            throw new RuntimeException("no object " + order + " found");
        }
    }


    public List<Order> sortByWaitersNameAndGet() {
        List<Order> sortedOrders = new ArrayList<>();
        List<Order> orders = orderHistoryDAO.getOrdersHistory().getOrders();

        sortedOrders.addAll(orders.stream().collect(Collectors.toList()));

        orders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getWaiter().getName().compareTo(o2.getWaiter().getName()) < 0) {
                    return -1;
                } else if (o1.getWaiter().getName().equals(o2.getWaiter().getName())) {
                    return 0;
                } else
                    return 1;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Order)) {
                    return false;
                }
                Order other = (Order) obj;
                return ((Order) obj).getWaiter().getName().equals(other.getWaiter().getName());
            }
        });

        return sortedOrders;
    }

    public List<Order> sortByOrdersDate(){
        List<Order> sortedOrders = new ArrayList<>();
        List<Order> orders = orderHistoryDAO.getOrdersHistory().getOrders();

        sortedOrders.addAll(orders.stream().collect(Collectors.toList()));

        orders.sort((o1, o2) -> {
            if (o1.getDate().compareTo(o2.getDate()) < 0) {
                return -1;
            } else if (o1.equals(o2)) {
                return 0;
            } else
                return 1;
        });
        return sortedOrders;
    }

    private boolean validateOrder(Order order) {
        return order != null;
    }

    public static void main(String[] args) {

        OrderHistoryService orderHistoryService = new OrderHistoryService();

        for (int i = 0; i < 10; i++) {
            Waiter waiter = new Waiter();
            waiter.setName("waiter"+i);
            Order order = new Order();
            order.setWaiter(waiter);
            orderHistoryService.setOrder(order);
        }

        orderHistoryService.sortByWaitersNameAndGet().forEach(System.out::println);

    }

}

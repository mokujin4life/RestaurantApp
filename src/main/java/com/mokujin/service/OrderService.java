package com.mokujin.service;

import com.mokujin.dao.order.IOrderDAO;
import com.mokujin.dao.order.OrderDAO;
import com.mokujin.models.menu.Menu;
import com.mokujin.models.order.Order;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class OrderService {
    OrderDAO orderDAO = new IOrderDAO();

    public void add(Order order) {
        validateDishAppearance(order);
        orderDAO.add(order);
    }

    public void get(Integer id) {
        if (id < orderDAO.getAll().size()) {
            orderDAO.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    public void delete(Order order) {
        orderDAO.delete(order);
    }

    public void edit(Order order){
        orderDAO.edit(order);
    }

    private void validateDishAppearance(Order order){
        if (order.getOrderedDishes().size()==0){
            throw new RuntimeException();
        }
    }
}

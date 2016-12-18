package com.mokujin.service;

import com.mokujin.dao.order.OrderDAO;
import com.mokujin.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    public void add(Order order) {
        /*boolean dishesAppearance = validateDishesAppearance(order);
        boolean orderValidation = validateObject(order);
        if (dishesAppearance && orderValidation) {
            validateDishAppearance(order);
            orderDAO.add(order);
        }*/
        orderDAO.add(order);

    }

    public void get(Integer id) {
       /* if (validateId(id)) {
            orderDAO.get(id);
        } else {
            throw new RuntimeException();
        }*/
        orderDAO.get(id);

    }

    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    public void delete(Integer id) {
        orderDAO.delete(id);
    }

    public void edit(Order order) {
        orderDAO.edit(order);
    }

    /*private void validateDishAppearance(Order order){
        if (order.getOrderedDishes().size()==0){
            throw new RuntimeException();
        }
    }
    private boolean validateDishesAppearance(Order order) {
        return order.getOrderedDishes().size() > 0;
    }

    private boolean validateObject(Order order) {
        return order != null;
    }

    private boolean validateId(Integer id) {
        return id < orderDAO.getAll().size() && id > 0;
    }*/
}

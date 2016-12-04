package com.mokujin.dao.order;

import com.mokujin.models.order.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokujin on 29.11.16.
 */
public class IOrderDAO implements OrderDAO {


    List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order get(Integer id) {
        try {
            return orders.get(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void add(Order order) {
        orders.add(order);
        getAll().forEach(item -> System.out.println(item));
    }

    @Override
    public void delete(Integer id) {
        try {
            orders.remove(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void edit(Order order) {
        try {
            orders.remove(order.getId());
            orders.add(order.getId(), order);
        } catch (Exception e) {
            throw new RuntimeException("no object=" + order + " found");
        }
    }

    /*SessionFactory sessionFactory;

    public List<Order> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select * from Order").list();
    }

    public Order get(Integer id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public void add(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void delete(Integer id) {
        Order order = (Order) sessionFactory.getCurrentSession().get(Order.class, id);
        sessionFactory.getCurrentSession().delete(order);
    }

    public void edit(Order order) {
        Order existingOrder = (Order) sessionFactory.getCurrentSession().get(Order.class, order.getId());

        existingOrder.setDate(order.getDate());
        existingOrder.setWaiter(order.getWaiter());
        existingOrder.setTableNumber(order.getTableNumber());

        sessionFactory.getCurrentSession().save(existingOrder);
    }*/
}

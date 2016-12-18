package com.mokujin.dao.order;

import com.mokujin.model.order.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokujin on 29.11.16.
 */
public class IOrderDAO implements OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Order> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o order by o.id").list();
    }

    @Override
    public Order get(int id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public void add(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void delete(Integer id) {
        Order order = sessionFactory.getCurrentSession().get(Order.class, id);
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void edit(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

}

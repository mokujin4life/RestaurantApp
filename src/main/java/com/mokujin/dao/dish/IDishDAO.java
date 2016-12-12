package com.mokujin.dao.dish;

import com.mokujin.model.dish.Dish;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class IDishDAO implements DishDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Dish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d order by d.id").list();
    }

    @Override
    public Dish get(int id) {
        return sessionFactory.getCurrentSession().get(Dish.class, id);
    }

    @Override
    public void add(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public void delete(Integer id) {
        Dish dish = sessionFactory.getCurrentSession().get(Dish.class, id);
        sessionFactory.getCurrentSession().delete(dish);
    }

    @Override
    public void edit(Dish dish) {
        sessionFactory.getCurrentSession().update(dish);
    }

}

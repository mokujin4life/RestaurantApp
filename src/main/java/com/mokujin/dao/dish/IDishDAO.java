package com.mokujin.dao.dish;

import com.mokujin.models.dish.Dish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danil-MAC on 11/28/16.
 */

public class IDishDAO implements DishDAO {
    List<Dish> dishes = new ArrayList<>();

    @Override
    public List<Dish> getAll() {
        return dishes;
    }

    @Override
    public Dish get(Integer id) {
        try {
            return dishes.get(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void add(Dish dish) {
        dishes.add(dish);
        getAll().forEach(item -> System.out.println(item));
    }

    @Override
    public void delete(Integer id) {
        try {
            dishes.remove(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void edit(Dish dish) {
        try {
            dishes.remove(dish.getId());
            dishes.add(dish.getId(), dish);
        } catch (Exception e) {
            throw new RuntimeException("no object=" + dish + " found");
        }
    }

    /*SessionFactory sessionFactory;

    @Override
    public List<Dish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select * from Dish").list();
    }

    public Dish get(Integer id) {
        return (Dish) sessionFactory.getCurrentSession().get(Dish.class, id);
    }

    public void add(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    public void delete(Integer id) {
        Dish dish = (Dish)sessionFactory.getCurrentSession().get(Dish.class, id);
        sessionFactory.getCurrentSession().delete(dish);
    }

    public void edit(Dish dish) {
        Dish existingDish = (Dish) sessionFactory.getCurrentSession().get(Dish.class, dish.getId());

        existingDish.setIngredientsMap(dish.getIngredientsMap());
        existingDish.setName(existingDish.getName());
        existingDish.setPrice(existingDish.getPrice());
        existingDish.setWeight(existingDish.getWeight());

        sessionFactory.getCurrentSession().save(existingDish);
    }*/

}
package com.mokujin.dao.dish;

import com.mokujin.models.dish.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
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
        dish.setId(dishes.size());
        dishes.add(dish);
        getAll().forEach(System.out::println);
    }

    @Override
    public void delete(Integer id) {
        try {
            for (Dish dish:dishes){
                if (dish.getId()==id){
                    dishes.remove(dish);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("no object with id=" + id + " found");
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

package com.mokujin.dao.ingredient;

import com.mokujin.model.ingredient.Ingredient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IIngredientDAO implements IngredientDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Ingredient> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i order by i.id").list();
    }

    @Override
    public Ingredient get(int id) {
        return sessionFactory.getCurrentSession().get(Ingredient.class, id);
    }

    @Override
    public void add(Ingredient ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
    }

    @Override
    public void delete(Integer id) {
        Ingredient ingredient = sessionFactory.getCurrentSession().get(Ingredient.class, id);
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Override
    public void edit(Ingredient ingredient) {
        sessionFactory.getCurrentSession().update(ingredient);
    }

}

package com.mokujin.dao.stock;

import com.mokujin.model.stock.StockIngredient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class IStockDAO implements StockDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<StockIngredient> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select i from StockIngredients i order by i.id").list();
    }

    @Override
    public StockIngredient get(int id) {
        return sessionFactory.getCurrentSession().get(StockIngredient.class, id);
    }

    @Override
    public void add(StockIngredient ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
    }

    @Override
    public void delete(Integer id) {
        StockIngredient ingredient = sessionFactory.getCurrentSession().get(StockIngredient.class, id);
        sessionFactory.getCurrentSession().delete(ingredient);
    }

    @Override
    public void edit(StockIngredient ingredient) {
        sessionFactory.getCurrentSession().update(ingredient);
    }



}

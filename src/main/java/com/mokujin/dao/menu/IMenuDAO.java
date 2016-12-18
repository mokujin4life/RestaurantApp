package com.mokujin.dao.menu;

import com.mokujin.model.ingredient.Ingredient;
import com.mokujin.model.menu.Menu;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokujin on 29.11.16.
 */
public class IMenuDAO implements MenuDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Menu> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m order by m.id").list();
    }

    @Override
    public Menu get(int id) {
        return sessionFactory.getCurrentSession().get(Menu.class, id);
    }

    @Override
    public void add(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void delete(Integer id) {
        Menu menu = sessionFactory.getCurrentSession().get(Menu.class, id);
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    public void edit(Menu menu) {
        sessionFactory.getCurrentSession().update(menu);
    }

}

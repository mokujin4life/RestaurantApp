package com.mokujin.dao.menu;

import com.mokujin.models.menu.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokujin on 29.11.16.
 */
public class IMenuDAO implements MenuDAO {


    List<Menu> menuList = new ArrayList<>();

    @Override
    public List<Menu> getAll() {
        return menuList;
    }

    @Override
    public Menu get(int id) {
        try {
            return menuList.get(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void add(Menu menu) {
        menuList.add(menu);
        getAll().forEach(System.out::println);
    }

    @Override
    public void delete(Integer id) {
        try {
            for (Menu menu : menuList) {
                if (menu.getId() == id) {
                    menuList.remove(menu);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("no object with id=" + id + " found");
        }
    }

    @Override
    public void edit(Menu menu) {
        try {
            menuList.remove(menu.getId());
            menuList.add(menu.getId(), menu);
        } catch (Exception e) {
            throw new RuntimeException("no object=" + menu + " found");
        }
    }
    /*SessionFactory sessionFactory;

    @Override
    public List<Menu> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select * from Menu").list();
    }

    @Override
    public Menu get(Integer id) {
        return (Menu) sessionFactory.getCurrentSession().get(Menu.class, id);
    }

    @Override
    public void add(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void delete(Integer id) {
        Menu menu = (Menu) sessionFactory.getCurrentSession().get(Menu.class, id);
        sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    public void edit(Menu menu) {
        Menu existingMenu = (Menu) sessionFactory.getCurrentSession().get(Menu.class, menu.getId());

        existingMenu.setDishList(menu.getDishList());
        existingMenu.setType(menu.getType());

        sessionFactory.getCurrentSession().save(existingMenu);
    }*/
}

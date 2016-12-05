package com.mokujin.service;

import com.mokujin.dao.menu.IMenuDAO;
import com.mokujin.dao.menu.MenuDAO;
import com.mokujin.models.menu.Menu;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class MenuService {

    MenuDAO menuDAO = new IMenuDAO();

    public void add(Menu menu) {
        boolean dishesAppearance = validateDishesAppearance(menu);
        boolean menuValidation = validateObject(menu);
        if (dishesAppearance && menuValidation) {
            validateDishAppearance(menu);
            menuDAO.add(menu);
        }
    }

    public void get(Integer id) {
        if (validateId(id)) {
            menuDAO.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Menu> getAll() {
        return menuDAO.getAll();
    }

    public void delete(Menu menu) {
        menuDAO.delete(menu);
    }

    public void edit(Menu menu){
        menuDAO.edit(menu);
    }

    private void validateDishAppearance(Menu menu){
        if (menu.getDishList().size()==0){
            throw new RuntimeException();
        }
    }

    private boolean validateDishesAppearance(Menu menu) {
        return menu.getDishList().size() > 0;
    }

    private boolean validateObject(Menu menu) {
        return menu != null;
    }

    private boolean validateId(Integer id) {
        return id < menuDAO.getAll().size() && id > 0;
    }

}

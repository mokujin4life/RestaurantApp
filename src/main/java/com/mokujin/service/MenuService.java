package com.mokujin.service;

import com.mokujin.dao.menu.IMenuDAO;
import com.mokujin.dao.menu.MenuDAO;
import com.mokujin.model.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuService {

    @Autowired
    MenuDAO menuDAO;

    public void add(Menu menu) {
        /*boolean dishesAppearance = validateDishesAppearance(menu);
        boolean menuValidation = validateObject(menu);
        if (dishesAppearance && menuValidation) {
            validateDishAppearance(menu);
            menuDAO.add(menu);
        }*/
        menuDAO.add(menu);

    }

    public Menu get(Integer id) {
       /* if (validateId(id)) {
            menuDAO.get(id);
        } else {
            throw new RuntimeException();
        }*/
        return menuDAO.get(id);
    }

    public List<Menu> getAll() {
        return menuDAO.getAll();
    }

    public void delete(Integer id) {
        menuDAO.delete(id);
    }

    public void edit(Menu menu) {
        menuDAO.edit(menu);
    }

    /*private void validateDishAppearance(Menu menu) {
        if (menu.getDishList().size() == 0) {
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
*/
}

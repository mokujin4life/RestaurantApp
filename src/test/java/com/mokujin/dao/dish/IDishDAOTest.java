package com.mokujin.dao.dish;

import com.mokujin.models.dish.Dish;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IDishDAOTest {

    DishDAO dishDAO;

    @Before
    public void setUp() throws Exception {
       dishDAO = new IDishDAO();

    }

    @Test
    public void getAll_WhenDataBaseIsEmptyThenEmptyListReturns() {
        List<Dish> expected = new ArrayList<>();

        List<Dish> result = dishDAO.getAll();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getAll_WhenAddNewDishThenOneElementListReturns() throws Exception {
        Dish dish = new Dish();
        dish.setName("nothing");
        dish.setPrice(1000);
        dish.setWeight(0);
        List<Dish> expected = new ArrayList<>();
        expected.add(dish);

        dishDAO.add(dish);

        List<Dish> result = dishDAO.getAll();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getAll_WhenDeleteADishThenListReturnsWithoutIt() throws Exception {
        Dish dish1 = new Dish();
        dish1.setName("nothing");
        dish1.setPrice(1000);
        dish1.setWeight(0);
        Dish dish2 = new Dish();
        dish2.setName("something");
        dish2.setPrice(0);
        dish2.setWeight(1000);
        List<Dish> expected = new ArrayList<>();
        expected.add(dish2);
        expected.add(dish1);
        expected.remove(dish2);

        dishDAO.add(dish2);
        dishDAO.add(dish1);
        dishDAO.delete(dish2);
        List<Dish> result = dishDAO.getAll();

        Assert.assertEquals(expected, result);
    }
}

package com.mokujin.dao.dish;

import com.mokujin.models.dish.Dish;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class IDishDAOTest {

    DishDAO dishDAO = new IDishDAOTest();

    @Test
    public void getAll_WhenDataBaseisEmptyThenEmptyListReturned(){
        List<Dish> expected = new ArrayList<>();

        List<Dish> result =
    }
}

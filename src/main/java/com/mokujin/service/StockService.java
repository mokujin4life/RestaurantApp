package com.mokujin.service;

import com.mokujin.dao.stock.IStockDAO;
import com.mokujin.dao.stock.StockDAO;
import com.mokujin.models.dish.Dish;
import com.mokujin.models.ingredient.Ingredient;
import com.mokujin.models.stock.Stock;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Danil on 05.12.16.
 */
public class StockService {
    StockDAO stockDAO = new IStockDAO();

    public Map<Ingredient, Integer> getIngredients() {
        return stockDAO.getStock().getAvailableIngredients();
    }


    public void setIngredient(Ingredient ingredient, Integer quantity) {
        Stock stock = stockDAO.getStock();
        stock.addNewIngredient(ingredient, quantity);
        stockDAO.updateStock(stock);
        getIngredients().forEach((k, v) -> System.out.println(k + " number = " + v));
    }


    public void deleteIngredient(Ingredient ingredient) {
        Stock stock = stockDAO.getStock();
        stock.getAvailableIngredients().remove(ingredient);
        stockDAO.updateStock(stock);
    }


    public Map<Ingredient, Integer> sortByNameAndGet() {
        Map<Ingredient, Integer> sortedIngredients = new TreeMap<>((o1, o2) -> {
            if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else if (o1.equals(o2)) {
                return 0;
            } else
                return 1;
        });

        Map<Ingredient, Integer> availableIngredients = stockDAO.getStock().getAvailableIngredients();

        for (Ingredient ingredient : availableIngredients.keySet()) {
            sortedIngredients.put(ingredient, availableIngredients.get(ingredient));
        }

        return sortedIngredients;
    }

    private boolean validateIngredientAppearance(Dish dish) {
        return dish.getIngredients().size() > 0;
    }

    private boolean validateObject(Dish dish) {
        return dish != null;
    }

    private boolean validate(Integer id) {
        return id < dishDAO.getAll().size() && id > 0;
    }
}

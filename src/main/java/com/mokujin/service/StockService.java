package com.mokujin.service;

import com.mokujin.dao.stock.StockDAO;
import com.mokujin.model.stock.StockIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockService {
    @Autowired
    StockDAO stockDAO;


    public void setIngredient(StockIngredient stockIngredient) {
        stockDAO.add(stockIngredient);
    }


    public void deleteIngredient(Integer id) {
        stockDAO.delete(id);
    }

    public StockIngredient getIngredient(Integer id) {
        return stockDAO.get(id);
    }

    public void editIngredient(StockIngredient ingredient) {
        stockDAO.edit(ingredient);
    }

    /*public Map<Ingredient, Integer> sortByNameAndGet() {
        Map<Ingredient, Integer> sortedIngredients = new TreeMap<>((o1, o2) -> {
            if (o1.getTitle().compareTo(o2.getTitle()) < 0) {
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
    }*/

    /*private boolean validateIngredient(Ingredient ingredient, Integer quantity) {
        return ingredient != null && quantity != null && quantity >= 0;
    }*/

}

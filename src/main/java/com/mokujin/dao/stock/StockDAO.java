package com.mokujin.dao.stock;

import com.mokujin.models.ingredient.Ingredient;
import com.mokujin.models.stock.Stock;

import java.util.Map;

/**
 * Created by Danil on 05.12.16.
 */
public interface StockDAO {
    Stock getStock();

    void updateStock(Stock stock);
}

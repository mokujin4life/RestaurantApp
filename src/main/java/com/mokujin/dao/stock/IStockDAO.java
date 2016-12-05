package com.mokujin.dao.stock;

import com.mokujin.models.ingredient.Ingredient;
import com.mokujin.models.stock.Stock;

import java.util.*;

/**
 * Created by Danil on 05.12.16.
 */
public class IStockDAO implements StockDAO {
    Stock stock = new Stock();

    @Override
    public Stock getStock() {
        return stock;
    }

    @Override
    public void updateStock(Stock stock) {
        this.stock = stock;
    }
}
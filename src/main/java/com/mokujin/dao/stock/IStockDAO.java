package com.mokujin.dao.stock;

import com.mokujin.model.stock.Stock;

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

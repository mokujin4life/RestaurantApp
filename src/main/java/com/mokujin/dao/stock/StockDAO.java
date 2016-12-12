package com.mokujin.dao.stock;

import com.mokujin.model.stock.Stock;

/**
 * Created by Danil on 05.12.16.
 */
public interface StockDAO {
    Stock getStock();

    void updateStock(Stock stock);
}

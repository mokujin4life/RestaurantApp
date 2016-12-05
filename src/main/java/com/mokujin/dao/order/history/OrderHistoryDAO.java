package com.mokujin.dao.order.history;

import com.mokujin.models.order.OrderHistory;

/**
 * Created by Danil on 05.12.16.
 */
public interface OrderHistoryDAO {
    OrderHistory getOrdersHistory();

    void updateOrdersHistory(OrderHistory orderHistory);
}
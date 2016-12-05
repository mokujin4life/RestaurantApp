package com.mokujin.dao.order.history;

import com.mokujin.models.order.OrderHistory;

/**
 * Created by Danil on 05.12.16.
 */
public class IOrderHistoryDAO implements OrderHistoryDAO {
    OrderHistory orders = new OrderHistory();

    @Override
    public OrderHistory getOrdersHistory() {
        return orders;
    }

    @Override
    public void updateOrdersHistory(OrderHistory orderHistory) {
        this.orders = orderHistory;
    }
}

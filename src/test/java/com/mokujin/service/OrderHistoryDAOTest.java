package com.mokujin.service;

import com.mokujin.models.employee.Waiter;
import com.mokujin.models.order.Order;
import org.junit.Test;

/**
 * Created by Danil on 05.12.16.
 */
public class OrderHistoryDAOTest {

    @Test
    public void test() {

        OrderHistoryService orderHistoryService = new OrderHistoryService();

        for (int i = 0; i < 10; i++) {
            Waiter waiter = new Waiter();
            waiter.setName("waiter"+i);
            Order order = new Order();
            order.setWaiter(waiter);
            orderHistoryService.setOrder(order);
        }

        orderHistoryService.sortByWaitersNameAndGet().forEach(System.out::println);

    }
}

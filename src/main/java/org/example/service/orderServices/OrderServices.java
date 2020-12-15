package org.example.service.orderServices;

import org.example.entity.Order;

import java.util.List;

public interface OrderServices {
    void saveOrder(Order order);

    void deleteOrder(int id);

    List getAllOrders();

    void addOrderFromMenu(int id,String username);

    Order getOrderById(int id);
}

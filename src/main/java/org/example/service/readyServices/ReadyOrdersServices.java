package org.example.service.readyServices;

import org.example.entity.Order;

import java.util.List;

public interface ReadyOrdersServices {

    void addNewReadyOrder(Order order);

    List getAllReadyOrders();

    void deleteReadyOrder(int idOrder);
}

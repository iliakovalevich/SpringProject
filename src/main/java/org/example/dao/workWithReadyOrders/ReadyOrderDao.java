package org.example.dao.workWithReadyOrders;

import org.example.entity.Order;

import java.util.List;

public interface ReadyOrderDao {
    void addNewReadyOrder(Order order);

    List getAllReadyOrders();

    void deleteReadyOrder(int idOrder);
}

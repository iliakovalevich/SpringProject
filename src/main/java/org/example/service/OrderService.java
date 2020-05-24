package org.example.service;

import java.util.List;

import org.example.entity.Order;

public interface OrderService {

    void save(Order order);

    void delete(int id, String tableName);

    void readyOrder(Order order);

    void addItemFromMenu(int id);

    List<Order> getAll(String tableName);

}

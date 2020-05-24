package org.example.dao;

import org.example.entity.Order;

import java.sql.Connection;
import java.util.List;

public interface ReadFromDataBase {
    void save(Order order);

    void saveReady(Order order);

    void delete(String sql);

    Order getFromMenuOrder(int id);

    List<Order> getAll(String sql);

    Connection dataBaseConnection();
}

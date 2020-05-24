package org.example.repository;

import org.example.domain.Order;

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

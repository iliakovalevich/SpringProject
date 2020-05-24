package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.entity.Order;
import org.example.dao.ReadFromDataBaseImpl;

public class OrderServiceImpl implements OrderService {

    private final ReadFromDataBaseImpl readFromDataBase = new ReadFromDataBaseImpl();

    public void save(Order order) {

        readFromDataBase.save(order);
    }

    public void delete(int id, String tableName) {
        String sql = "DELETE FROM shop." + tableName + " WHERE id = " + id;
        readFromDataBase.delete(sql);
    }

    public void addItemFromMenu(int id) {
        readFromDataBase.save(readFromDataBase.getFromMenuOrder(id));
    }

    public List<Order> getAll(String tableName) {
        ReadFromDataBaseImpl readFromDataBase = new ReadFromDataBaseImpl();
        return new ArrayList<>(readFromDataBase.getAll("SELECT * FROM shop." + tableName));
    }

    public void readyOrder(Order order) {
        readFromDataBase.saveReady(order);
    }

}

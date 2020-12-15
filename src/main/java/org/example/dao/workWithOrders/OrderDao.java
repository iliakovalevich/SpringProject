package org.example.dao.workWithOrders;


import org.example.entity.Order;

import java.util.List;

public interface OrderDao {
    public void saveOrder(Order order);

    public void deleteOrder(int idOrder);

    public List getAllOrders();

    public Order getOrderById(int idOrder);

    public void updateOrder(Order order);

}

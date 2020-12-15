package org.example.dao.workWithOrders;

import org.example.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setIdOrder(resultSet.getInt("idOrder"));
        order.setTitleOrder(resultSet.getString("titleOrder"));
        order.setPriceOrder(resultSet.getDouble("priceOrder"));
        return order;
    }
}

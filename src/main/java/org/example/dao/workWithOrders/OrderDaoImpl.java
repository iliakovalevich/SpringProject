package org.example.dao.workWithOrders;

import org.example.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrder(Order order) {
        String SQL = "INSERT INTO orders (titleOrder,priceOrder) VALUES (?,?)";
        jdbcTemplate.update(SQL,order.getTitleOrder(),order.getPriceOrder());
    }


    @Override
    public void deleteOrder(int idOrder) {
        String SQL = "DELETE FROM orders WHERE idOrder = ?";
        jdbcTemplate.update(SQL, idOrder);
    }

    @Override
    public List getAllOrders() {
        String SQL = "SELECT * FROM orders";
        return jdbcTemplate.query(SQL, new OrderMapper());
    }

    @Override
    public Order getOrderById(int idOrder) {
        String SQL = "SELECT * FROM orders WHERE idOrder = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{idOrder}, new OrderMapper());
    }

    @Override
    public void updateOrder(Order order) {
        String SQL = "UPDATE orders SET titleOrder = ?, priceOrder = ? WHERE idOrder = ?";
        jdbcTemplate.update(SQL, order.getTitleOrder(), order.getPriceOrder(), order.getIdOrder());
    }
}

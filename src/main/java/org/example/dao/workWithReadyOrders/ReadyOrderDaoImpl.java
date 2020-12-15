package org.example.dao.workWithReadyOrders;

import org.example.dao.workWithOrders.OrderMapper;
import org.example.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ReadyOrderDaoImpl implements ReadyOrderDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addNewReadyOrder(Order order) {
        String SQL = "INSERT INTO readyOrders (titleOrder,priceOrder) VALUES (?,?)";
        jdbcTemplate.update(SQL,order.getTitleOrder(),order.getPriceOrder());
    }

    @Override
    public List getAllReadyOrders() {
        String SQL = "SELECT * FROM readyOrders";
        return jdbcTemplate.query(SQL, new OrderMapper());
    }

    @Override
    public void deleteReadyOrder(int idOrder) {
        String SQL = "DELETE FROM readyOrders WHERE idOrder = ?";
        jdbcTemplate.update(SQL, idOrder);
    }
}

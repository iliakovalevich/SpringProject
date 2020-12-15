package org.example.dao.workWithMenu;

import org.example.dao.workWithOrders.OrderMapper;
import org.example.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.awt.*;
import java.util.List;

public class MenuDaoImpl implements MenuDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List getAllProductsFromMenu() {
        String SQL = "SELECT * FROM products";
        return jdbcTemplate.query(SQL, new MenuMapper());
    }

    @Override
    public void updateItemInMenu(Product product) {
        String SQL = "UPDATE products SET titleProduct = ?, priceProduct = ? WHERE idProduct = ?";
        jdbcTemplate.update(SQL, product.getTitleProduct(), product.getPriceProduct(), product.getIdProduct());
    }

    @Override
    public void createMenuItem(String titleProduct,double priceProduct) {
        String SQL = "INSERT INTO products (titleProduct,priceProduct) VALUES (?,?)";
        jdbcTemplate.update(SQL, titleProduct, priceProduct);
    }

    @Override
    public Product getProductFromMenuById(int idProduct) {
        String SQL = "SELECT * FROM products WHERE idProduct = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{idProduct}, new MenuMapper());
    }

    @Override
    public void deleteProductFromMenu(int idProduct) {
        String SQL = "DELETE FROM products WHERE idProduct = ?";
        jdbcTemplate.update(SQL, idProduct);
    }
}

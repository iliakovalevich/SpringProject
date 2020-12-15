package org.example.dao.workWithMenu;

import org.example.entity.Order;
import org.example.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setIdProduct(resultSet.getInt("idProduct"));
        product.setTitleProduct(resultSet.getString("titleProduct"));
        product.setPriceProduct(resultSet.getDouble("priceProduct"));
        return product;
    }
}

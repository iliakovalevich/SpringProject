package org.example.dao;

import org.example.domain.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFromDataBaseImpl implements ReadFromDataBase {
    @Override
    public void save(Order order) {
        try (Connection connection = dataBaseConnection()) {
            String sql = "INSERT INTO shop.order (title, price) Values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getTitle());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    @Override
    public void saveReady(Order order) {
        try (Connection connection = dataBaseConnection()) {
            String sql = "INSERT INTO shop.ready (id,title, price) Values (?,?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getTitle());
            preparedStatement.setDouble(3, order.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    @Override
    public void delete(String sql) {
        try (Connection connection = dataBaseConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }

    @Override
    public Order getFromMenuOrder(int id) {
        Order order = new Order();
        try (Connection connection = dataBaseConnection()) {
            String sql = "SELECT * FROM shop.menu WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
//                    int Id = resultSet.getInt(1);
//                    String title = resultSet.getString(2);
//                    double price = resultSet.getDouble(3);
                    order.setId(resultSet.getInt(1));
                    order.setTitle(resultSet.getString(2));
                    order.setPrice(resultSet.getDouble(3));
                    return order;
                }
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
        return null;
    }

    @Override
    public List<Order> getAll(String sql) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = dataBaseConnection()) {
            Statement statement = Objects.requireNonNull(connection).createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setTitle(resultSet.getString("title"));
                order.setPrice(resultSet.getDouble("price"));
                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Connection dataBaseConnection() {
        try {
            String url = "jdbc:mysql://localhost/shop?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "10033223391";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                return DriverManager.getConnection(url, username, password);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

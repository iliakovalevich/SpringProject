package org.example.dao.workWithAdmins;

import org.example.entity.persons.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        admin.setUsername(resultSet.getString("adminName"));
        admin.setPassword(resultSet.getString("adminPassword"));
        return admin;
    }
}

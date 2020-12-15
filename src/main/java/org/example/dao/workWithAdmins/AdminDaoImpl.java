package org.example.dao.workWithAdmins;

import org.example.dao.workWithMenu.MenuMapper;
import org.example.entity.persons.Admin;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean checkAdmin(String username, String password) {
        String SQL = "SELECT * FROM admins";
        List<Admin> admins = jdbcTemplate.query(SQL, new AdminMapper());
        for (Admin admin: admins){
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password))
                return true;
            else return false;
        }
        return false;
    }
}

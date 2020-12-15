package org.example.dao.workWithClients;

import org.example.entity.persons.Client;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean checkClient(String username, String password) {
        String SQL = "SELECT * FROM clients";
        List<Client> clientsList = jdbcTemplate.query(SQL, new ClientMapper());
        for (Client client : clientsList) {
            if (client.getClientName().equals(username) && client.getClientPassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public boolean registration(String username, String password, String address) {
        String SQL_CHECK = "SELECT * FROM clients";
        List<Client> clientList = jdbcTemplate.query(SQL_CHECK, new ClientMapper());
        for (Client client:clientList){
            if (client.getClientName().equals(username))
                return false;
        }
        String SQL = "INSERT INTO clients (clientName,clientPassword,address) VALUES(?,?,?)";
        jdbcTemplate.update(SQL, username, password, address);
        return true;
    }

    @Override
    public void addOrder(int idOrder,String username) {
        String SQL = "UPDATE clients SET idOrder = ? WHERE clientName = ?";
        jdbcTemplate.update(SQL, idOrder,username);
    }

}

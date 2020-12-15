package org.example.dao.workWithClients;

import org.example.entity.persons.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setClientName(resultSet.getString("clientName"));
        client.setClientPassword(resultSet.getString("clientPassword"));
        client.setIdOrder(resultSet.getInt("idOrder"));
        client.setAddress(resultSet.getString("address"));
        return client;
    }
}

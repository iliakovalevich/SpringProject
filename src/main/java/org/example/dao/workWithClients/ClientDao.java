package org.example.dao.workWithClients;

public interface ClientDao {
    boolean checkClient(String username,String password);

    boolean registration(String username,String password,String address);

    void addOrder(int idOrder,String username);
}

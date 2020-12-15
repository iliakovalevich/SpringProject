package org.example.entity.persons;

public class Client {
    String clientName;
    String clientPassword;
    int idOrder;
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Client() {
    }

    public Client(String clientName, String clientPassword) {
        this.clientName = clientName;
        this.clientPassword = clientPassword;
    }

    public Client(String clientName, String clientPassword, int idOrder,String address) {
        this.clientName = clientName;
        this.clientPassword = clientPassword;
        this.idOrder = idOrder;
        this.address= address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + getClientName() + '\'' +
                ", clientPassword='" + getClientPassword() + '\'' +
                ", idOrder=" + getIdOrder() +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}

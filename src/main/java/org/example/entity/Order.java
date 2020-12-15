package org.example.entity;

public class Order {

    private Integer idOrder;
    private String titleOrder;
    private Double priceOrder;

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getTitleOrder() {
        return titleOrder;
    }

    public void setTitleOrder(String titleOrder) {
        this.titleOrder = titleOrder;
    }

    public Double getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(Double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Order() {
    }

    public Order(String titleOrder, Double priceOrder) {
        this.titleOrder = titleOrder;
        this.priceOrder = priceOrder;
    }

    public Order(Integer idOrder, String titleOrder, Double priceOrder) {
        this.idOrder = idOrder;
        this.titleOrder = titleOrder;
        this.priceOrder = priceOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + getIdOrder() +
                ", titleOrder='" + getTitleOrder() + '\'' +
                ", priceOrder=" + getPriceOrder() +
                '}';
    }
}

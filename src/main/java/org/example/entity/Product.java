package org.example.entity;

public class Product {
    private Integer idProduct;
    private String titleProduct;
    private Double priceProduct;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Product(Integer idProduct, String titleProduct, Double priceProduct) {
        this.idProduct = idProduct;
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
    }

    public Product(String titleProduct, Double priceProduct) {
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id product=" + getIdProduct() +
                ", title product='" + getTitleProduct() + '\'' +
                ", price product=" + getPriceProduct() +
                '}';
    }
}

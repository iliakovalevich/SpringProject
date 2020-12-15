package org.example.service.menuServices;

import org.example.entity.Product;

import java.util.List;

public interface MenuServices {

    List getAllProductsFromMenu();

    void updateItemInMenu(Product product);

    void createMenuItem(String titleProduct,double priceProduct);

    Product getProductFromMenuById(int idProduct);

    void deleteProductFromMenu(int idProduct);

}

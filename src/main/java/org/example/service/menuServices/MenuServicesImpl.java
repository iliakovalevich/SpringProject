package org.example.service.menuServices;

import org.example.dao.workWithMenu.MenuDaoImpl;
import org.example.dao.workWithOrders.OrderDaoImpl;
import org.example.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuServicesImpl implements MenuServices {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbctemplate-config.xml");
    MenuDaoImpl menuDao = (MenuDaoImpl) context.getBean("jdbcTemplateMenuDao");

    @Override
    public List getAllProductsFromMenu() {
        return menuDao.getAllProductsFromMenu();
    }

    @Override
    public void updateItemInMenu(Product product) {
        menuDao.updateItemInMenu(product);
    }

    @Override
    public void createMenuItem(String titleProduct, double priceProduct) {
        menuDao.createMenuItem(titleProduct, priceProduct);
    }

    @Override
    public Product getProductFromMenuById(int id) {
        return menuDao.getProductFromMenuById(id);
    }

    @Override
    public void deleteProductFromMenu(int idProduct) {
        menuDao.deleteProductFromMenu(idProduct);
    }
}

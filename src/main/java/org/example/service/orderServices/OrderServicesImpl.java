package org.example.service.orderServices;

import org.example.dao.workWithOrders.OrderDaoImpl;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.menuServices.MenuServicesImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrderServicesImpl implements OrderServices {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbctemplate-config.xml");
    OrderDaoImpl orderDao = (OrderDaoImpl) context.getBean("jdbcTemplateOrderDao");
    private MenuServicesImpl menuServices;

    public OrderServicesImpl(){
        menuServices = new MenuServicesImpl();
    }

    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderDao.deleteOrder(id);
    }

    @Override
    public List getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    public void addOrderFromMenu(int id) {
        Order order = new Order();
        Product product = new Product();
        product=menuServices.getProductFromMenuById(id);
        order.setTitleOrder(product.getTitleProduct());
        order.setPriceOrder(product.getPriceProduct());
        orderDao.saveOrder(order);
    }


}

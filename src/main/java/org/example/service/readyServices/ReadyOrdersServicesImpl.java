package org.example.service.readyServices;

import org.example.dao.workWithOrders.OrderDaoImpl;
import org.example.dao.workWithReadyOrders.ReadyOrderDaoImpl;
import org.example.entity.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ReadyOrdersServicesImpl implements ReadyOrdersServices {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbctemplate-config.xml");
    ReadyOrderDaoImpl readyOrderDao = (ReadyOrderDaoImpl) context.getBean("jdbcTemplateReadyOrderDao");

    @Override
    public void addNewReadyOrder(Order order) {
        readyOrderDao.addNewReadyOrder(order);
    }

    @Override
    public List getAllReadyOrders() {
        return readyOrderDao.getAllReadyOrders();
    }

    @Override
    public void deleteReadyOrder(int idOrder) {
        readyOrderDao.deleteReadyOrder(idOrder);
    }
}

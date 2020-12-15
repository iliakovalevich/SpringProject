package org.example.service.clientServices;

import org.example.dao.workWithClients.ClientDaoImpl;
import org.example.dao.workWithOrders.OrderDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientServicesImpl implements ClientServices{
    ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbctemplate-config.xml");
    OrderDaoImpl orderDao = (OrderDaoImpl) context.getBean("jdbcTemplateOrderDao");
    ClientDaoImpl clientDao=(ClientDaoImpl) context.getBean("jdbcTemplateClientDao");
    @Override
    public void addOrder(int idOrder) {

    }
}

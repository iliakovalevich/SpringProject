package org.example.service.loginServices;

import org.example.dao.workWithAdmins.AdminDaoImpl;
import org.example.dao.workWithClients.ClientDaoImpl;
import org.example.dao.workWithMenu.MenuDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServicesImpl implements LoginServices {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbctemplate-config.xml");
    AdminDaoImpl adminDao = (AdminDaoImpl) context.getBean("jdbcTemplateAdminDao");
    ClientDaoImpl clientDao = (ClientDaoImpl) context.getBean("jdbcTemplateClientDao");

    public String login(String username, String password) {
        if (adminDao.checkAdmin(username, password))
            return "admin";
        else if (clientDao.checkClient(username, password))
            return "client";
        return "false";
    }

    @Override
    public boolean registration(String username, String password, String address) {
        return clientDao.registration(username, password, address);
    }
}

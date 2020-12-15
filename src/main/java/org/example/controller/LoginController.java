package org.example.controller;

import org.example.entity.Order;
import org.example.service.loginServices.LoginServices;
import org.example.service.loginServices.LoginServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {
    LoginServicesImpl loginServices = new LoginServicesImpl();
    MenuController menuController = new MenuController();
    OrderController orderController = new OrderController();
    ClientController clientController=new ClientController();
    @RequestMapping(value = "/loginPage")
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model ,
            @RequestParam(value = "login") String username, @RequestParam(value = "password") String password) {
        String result = loginServices.login(username, password);
        if (result.equals("admin"))
            return menuController.menuControllerPage(model);
        else if (result.equals("client")){
            clientController.setUsername(username);
            return clientController.addNewClientPage(model);
        }
        else return "loginPage";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(Model model,
                                @RequestParam(value="login") String login,
                               @RequestParam(value="password") String password,
                               @RequestParam(value="address") String address){
        loginServices.registration(login,password,address);
        return "loginPage";
    }

}

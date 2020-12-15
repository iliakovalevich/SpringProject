package org.example.controller;

import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.menuServices.MenuServicesImpl;
import org.example.service.orderServices.OrderServices;
import org.example.service.orderServices.OrderServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientController {
    MenuServicesImpl menuServices = new MenuServicesImpl();
    OrderServices orderServicesImpl = new OrderServicesImpl();
    MainController mainController=new MainController();
    private String username;


    @RequestMapping(value = "/pageForClient", method = RequestMethod.GET)
    public String addNewClientPage(Model model) {
        List<Product> menuList = menuServices.getAllProductsFromMenu();
        model.addAttribute("menuList", menuList);
        return "pageForClient";
    }

    @RequestMapping(value = "addOrder/{idProduct}", method = RequestMethod.GET)
    public String addItemFromMenu(Model model,@PathVariable int idProduct) {
        orderServicesImpl.addOrderFromMenu(idProduct, getUsername());

//        orderService.addItemFromMenu(id);
        return addNewClientPage(model);
    }
    @RequestMapping(value = "/logout")
    public String logout(Model model){
        setUsername(null);
        return mainController.getOrderPage(model);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

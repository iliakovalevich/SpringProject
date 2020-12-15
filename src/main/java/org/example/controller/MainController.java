package org.example.controller;

import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.menuServices.MenuServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    MenuServicesImpl menuServices=new MenuServicesImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<Product> menuList = menuServices.getAllProductsFromMenu();
        model.addAttribute("menuList", menuList);
        return "order";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String menuControllerPage(Model model) {
        List<Product> menuList = menuServices.getAllProductsFromMenu();
        model.addAttribute("menuList", menuList);
        return "redirect:/";
    }
}

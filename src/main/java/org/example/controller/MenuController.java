package org.example.controller;

import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.menuServices.MenuServices;
import org.example.service.menuServices.MenuServicesImpl;
import org.example.service.orderServices.OrderServices;
import org.example.service.orderServices.OrderServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MenuController {
    MenuServicesImpl menuServices = new MenuServicesImpl();
    OrderServicesImpl orderServices = new OrderServicesImpl();

    @RequestMapping(value = "/pageForAdmin", method = RequestMethod.GET)
    public String menuControllerPage(Model model) {
        List<Product> menuList = menuServices.getAllProductsFromMenu();
        List<Order> orderList=orderServices.getAllOrders();
        model.addAttribute("menuList", menuList);
        model.addAttribute("orderList",orderList);
        return "pageForAdmin";
    }

    @RequestMapping(value = "deleteProduct/{idProduct}", method = RequestMethod.GET)
    public String addItemFromMenu(Model model,@PathVariable int idProduct) {
        menuServices.deleteProductFromMenu(idProduct);
//        orderService.addItemFromMenu(id);
        return menuControllerPage(model);
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(Model model,@RequestParam(value = "idProduct") int idProduct,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "price") double price) {
        Product product= new Product(idProduct,title,price);
        menuServices.updateItemInMenu(product);
        return menuControllerPage(model);

    }

    @RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
    public String addNewProductInMenu(Model model,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "price") double price) {
        menuServices.createMenuItem(title,price);
        return menuControllerPage(model);
    }

    @RequestMapping(value = "orderIsComplete/{idOrder}",method = RequestMethod.POST)
    public String orderIsComplete(Model model,@PathVariable int idOrder){
        orderServices.deleteOrder(idOrder);
        return menuControllerPage(model);
    }

}

package org.example.controller;

import java.util.List;

import org.example.entity.Product;
import org.example.service.menuServices.MenuServicesImpl;
import org.example.service.orderServices.OrderServices;
import org.example.service.orderServices.OrderServicesImpl;
import org.example.service.readyServices.ReadyOrdersServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.example.entity.Order;


@Controller
public class OrderController {


    private final OrderServices orderServices = new OrderServicesImpl();
    private final MenuServicesImpl menuServices = new MenuServicesImpl();
    private final ReadyOrdersServicesImpl readyOrdersServices = new ReadyOrdersServicesImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Model model) {
//        List<Order> orders = orderService.getAll("order");
//        List<Order> ready = orderService.getAll("ready");
        List<Order> orders = orderServices.getAllOrders();
        List<Order> readyOrder = readyOrdersServices.getAllReadyOrders();
        model.addAttribute("orderList", orders);
        model.addAttribute("readyOrder", readyOrder);
        return "order";
    }

    @RequestMapping(value = "/add-new-order", method = RequestMethod.GET)
    public String addNewOrderPage(Model model) {
//        List<Order> menu = orderService.getAll("menu");
        List<Product> menuList = menuServices.getAllProductsFromMenu();
        model.addAttribute("menuList", menuList);
        return "addNewOrder";
    }

    @RequestMapping(value = "/add-new-order", method = RequestMethod.POST)
    public String addNewOrder(
            @RequestParam(value = "title") String title, @RequestParam(value = "price") double price) {
        Order order = new Order();
        order.setTitleOrder(title);
        order.setPriceOrder(price);
        orderServices.saveOrder(order);
//        orderService.save(order);
        return "redirect:/";
    }

    @RequestMapping(value = "addMenu/{idProduct}",method = RequestMethod.GET)
    public String addItemFromMenu(@PathVariable int idProduct) {
        orderServices.addOrderFromMenu(idProduct);
//        orderService.addItemFromMenu(id);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{idOrder}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable int idOrder) {
//        orderService.delete(id, "ready");
        readyOrdersServices.deleteReadyOrder(idOrder);
        return "redirect:/";
    }

    @RequestMapping(value = "ready/{idOrder}/{titleOrder}/{priceOrder}", method = RequestMethod.GET)
    public String readyOrder(@PathVariable int idOrder, @PathVariable String titleOrder,
                             @PathVariable double priceOrder) {
        Order order = new Order();
        order.setIdOrder(idOrder);
        order.setTitleOrder(titleOrder);
        order.setPriceOrder(priceOrder);
//        orderService.readyOrder(order);
        readyOrdersServices.addNewReadyOrder(order);
//        orderService.delete(id, "order");
        orderServices.deleteOrder(idOrder);
        return "redirect:/";
    }
}

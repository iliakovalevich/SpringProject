package org.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.example.entity.Order;
import org.example.service.OrderServiceImpl;

@Controller
public class OrderController {

    private final OrderServiceImpl orderService = new OrderServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<Order> orders = orderService.getAll("order");
        List<Order> ready = orderService.getAll("ready");
        model.addAttribute("orderList", orders);
        model.addAttribute("readyOrder", ready);
        return "order";
    }

    @RequestMapping(value = "/add-new-order", method = RequestMethod.GET)
    public String addNewOrderPage(Model model) {
        List<Order> menu = orderService.getAll("menu");
        model.addAttribute("menuList", menu);
        return "addNewOrder";
    }

    @RequestMapping(value = "/add-new-order", method = RequestMethod.POST)
    public String addNewOrder(
            @RequestParam(value = "title") String title, @RequestParam(value = "price") double price) {
        Order order = new Order();
        order.setTitle(title);
        order.setPrice(price);
        orderService.save(order);
        return "redirect:/";
    }

    @RequestMapping("addMenu/{id}")
    public String addItemFromMenu(@PathVariable int id) {
        orderService.addItemFromMenu(id);
        return "redirect:/";
    }

    @RequestMapping("delete/{id}")
    public String deleteItem(@PathVariable int id) {
        orderService.delete(id, "ready");
        return "redirect:/";
    }

    @RequestMapping("ready/{id}/{title}/{price}")
    public String readyOrder(@PathVariable int id, @PathVariable String title, @PathVariable double price) {
        Order order = new Order();
        order.setId(id);
        order.setTitle(title);
        order.setPrice(price);
        orderService.readyOrder(order);
        orderService.delete(id, "order");
        return "redirect:/";
    }
}

package com.pierzchala.springfive.controller;

import com.pierzchala.springfive.tacos.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private Logger LOGGER = LoggerFactory.getLogger("Logger");

    @GetMapping("/current")
    public String orderForm(Model model) {
        Order order = new Order();
        order.setName("Michal");
        order.setCity("Warszawa");
        model.addAttribute("order", order);
        return "orderForm";
    }

    @PostMapping
    public String processOrder() {
        LOGGER.info("Zamówienie zostało złożone ");
        return "redirect:/";
    }
}
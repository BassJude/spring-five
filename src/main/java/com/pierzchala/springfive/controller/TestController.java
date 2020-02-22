package com.pierzchala.springfive.controller;

import com.pierzchala.springfive.tacos.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model) {
        Order order = new Order();
        order.setName("Antek");
        order.setStreet("Czapelska");
        model.addAttribute("order", order);
        model.addAttribute("message", "Raz dwa trzy");

        return "test2";
    }

    @PostMapping("/test")
    @ResponseBody
    public String test(Model model, @ModelAttribute Order order) {
        System.out.println("Name " + order.getName());
        System.out.println("Street " + order.getStreet());

        return "Response";

    }
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/demo")
    public String init(Model model) {
        model.addAttribute("message", "Hello Thymeleaf.");
        return "demo";
    }
}
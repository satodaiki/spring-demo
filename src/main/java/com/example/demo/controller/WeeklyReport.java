package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/weeklyReport")
public class WeeklyReport {

    @RequestMapping("/init")
    public String init(Model model) {
        return "weeklyReport";
    }

    @RequestMapping("doPost")
    public String doPost(Model model) {
        Map<String, Object> modelMap = model.asMap();

        return "weeklyReport";
    }
}

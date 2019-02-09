package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/weeklyReport")
public class WeeklyReportController {

    @RequestMapping("/init")
    public String init() {
        return "weeklyReport";
    }

    @RequestMapping("/post")
    public String doPost(@RequestBody String body, Model model) {
        model.addAttribute("text", body);
        return "weeklyReport";
    }
}

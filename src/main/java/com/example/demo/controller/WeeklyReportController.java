package com.example.demo.controller;

import com.example.demo.model.CalendarModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/weeklyReport")
public class WeeklyReportController {

    @RequestMapping("/init")
    public String init(Model model) {

        // 現在日付の作成
        List<String> dayOfWeekList = CalendarModel.getDayOfWeek(CalendarModel.START_MONDAY);

        model.addAttribute("dayOfWeekList", dayOfWeekList);

        return "weeklyReport";
    }

    @RequestMapping("/post")
    public String doPost(@RequestBody String body, Model model) {
        model.addAttribute("text", body);
        return "weeklyReport";
    }
}

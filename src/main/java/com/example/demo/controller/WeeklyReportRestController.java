package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("webapi/weeklyReport")
public class WeeklyReportRestController {

    /**
     * 現在の月のカレンダーを取得
     *
     * @return 現在の月カレンダーのJSON
     */
    @RequestMapping(value = "getCurrentMonth",produces = "application/json;charset=UTF-8")
    public String getCurrentMonth() {

        // 勤務情報を格納する
        Map<Integer, Object> calendarMap = new LinkedHashMap<>();



        calendarMap.put(1, "aaa");

        try {
            return new ObjectMapper().writeValueAsString(calendarMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }


    @RequestMapping(value = "getNextMonth", produces = "application/json;charset=UTF-8")
    public String getNextMonth(Model model) {
        // json文字列を生成
        String response = "";

        return response;
    }
}

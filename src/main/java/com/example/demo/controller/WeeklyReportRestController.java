package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("webapi/weeklyReport")
public class WeeklyReportRestController {

    /**
     * 現在の月のカレンダーを取得
     *
     * @return 現在月、前月、来月の情報を取得
     */
    @RequestMapping(value = "getCurrentMonth",produces = "application/json;charset=UTF-8")
    public String getCurrentMonth() {

        // カレンダー情報
        Map<String, Object> calendarMap = new LinkedHashMap<>();

        Map<Integer, Object> currentCalendarMap = new LinkedHashMap<>();

        Map<Integer, Object> nextCalendarMap = new LinkedHashMap<>();

        Map<Integer, Object> prevCalendarMap = new LinkedHashMap<>();

        Calendar currentCal = Calendar.getInstance();

        int nextYear = currentCal.get(Calendar.MONTH) == 12 ? currentCal.get(Calendar.YEAR) + 1 : currentCal.get(Calendar.YEAR);
        int nextMonth = currentCal.get(Calendar.MONTH) == 12 ? 1 : currentCal.get(Calendar.MONTH);
        int prevYear = currentCal.get(Calendar.MONTH) == 1 ? currentCal.get(Calendar.YEAR) - 1 : currentCal.get(Calendar.YEAR);
        int prevMonth = currentCal.get(Calendar.MONTH) == 1 ? 12 : currentCal.get(Calendar.MONTH);

        for (int i = 1; i <= currentCal.getActualMaximum(Calendar.DATE); i++) {
            currentCalendarMap.put(i, "");
        }

        Calendar nextCal = Calendar.getInstance();
        nextCal.set(Calendar.YEAR, nextYear);
        nextCal.set(Calendar.MONTH, nextMonth);

        for (int i = 1; i <= nextCal.getActualMaximum(Calendar.DATE); i++) {
            nextCalendarMap.put(i, "");
        }

        Calendar prevCal = Calendar.getInstance();
        prevCal.set(Calendar.YEAR, prevYear);
        prevCal.set(Calendar.MONTH, prevMonth);

        for (int i = 1; i <= prevCal.getActualMaximum(Calendar.DATE); i++) {
            prevCalendarMap.put(i, "");
        }

        calendarMap.put("currentCal", currentCalendarMap);
        calendarMap.put("nextCal", nextCalendarMap);
        calendarMap.put("prevCal", prevCalendarMap);

        try {
            return new ObjectMapper().writeValueAsString(calendarMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }
}

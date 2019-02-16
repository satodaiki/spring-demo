package com.example.demo.controller;

import com.example.demo.beans.CalendarBeans;
import com.example.demo.model.CalendarModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
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
            CalendarBeans calendarBeans = new CalendarBeans();

            currentCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(currentCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(currentCal.get(Calendar.DAY_OF_WEEK)));

            currentCalendarMap.put(i, calendarBeans);
        }

        Calendar nextCal = Calendar.getInstance();
        nextCal.set(Calendar.YEAR, nextYear);
        nextCal.set(Calendar.MONTH, nextMonth);

        for (int i = 1; i <= nextCal.getActualMaximum(Calendar.DATE); i++) {
            CalendarBeans calendarBeans = new CalendarBeans();

            nextCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(nextCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(nextCal.get(Calendar.DAY_OF_WEEK)));

            nextCalendarMap.put(i, calendarBeans);
        }

        Calendar prevCal = Calendar.getInstance();
        prevCal.set(Calendar.YEAR, prevYear);
        prevCal.set(Calendar.MONTH, prevMonth);

        for (int i = 1; i <= prevCal.getActualMaximum(Calendar.DATE); i++) {
            CalendarBeans calendarBeans = new CalendarBeans();

            prevCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(prevCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(prevCal.get(Calendar.DAY_OF_WEEK)));

            prevCalendarMap.put(i, calendarBeans);
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

    @RequestMapping(value = "getTargetMonth/{year}/{month}",produces = "application/json;charset=UTF-8")
    public String getTargetMonth(@PathVariable("year") String year) {

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
            CalendarBeans calendarBeans = new CalendarBeans();

            currentCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(currentCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(currentCal.get(Calendar.DAY_OF_WEEK)));

            currentCalendarMap.put(i, calendarBeans);
        }

        Calendar nextCal = Calendar.getInstance();
        nextCal.set(Calendar.YEAR, nextYear);
        nextCal.set(Calendar.MONTH, nextMonth);

        for (int i = 1; i <= nextCal.getActualMaximum(Calendar.DATE); i++) {
            CalendarBeans calendarBeans = new CalendarBeans();

            nextCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(nextCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(nextCal.get(Calendar.DAY_OF_WEEK)));

            nextCalendarMap.put(i, calendarBeans);
        }

        Calendar prevCal = Calendar.getInstance();
        prevCal.set(Calendar.YEAR, prevYear);
        prevCal.set(Calendar.MONTH, prevMonth);

        for (int i = 1; i <= prevCal.getActualMaximum(Calendar.DATE); i++) {
            CalendarBeans calendarBeans = new CalendarBeans();

            prevCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(prevCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(prevCal.get(Calendar.DAY_OF_WEEK)));

            prevCalendarMap.put(i, calendarBeans);
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

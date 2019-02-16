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

        Calendar currentCal = Calendar.getInstance();

        int nextYear = currentCal.get(Calendar.MONTH) == 11 ? currentCal.get(Calendar.YEAR) + 1 : currentCal.get(Calendar.YEAR);
        int nextMonth = currentCal.get(Calendar.MONTH) == 11 ? 0 : currentCal.get(Calendar.MONTH);
        int prevYear = currentCal.get(Calendar.MONTH) == 0 ? currentCal.get(Calendar.YEAR) - 1 : currentCal.get(Calendar.YEAR);
        int prevMonth = currentCal.get(Calendar.MONTH) == 0 ? 11 : currentCal.get(Calendar.MONTH);

        Map<Integer, CalendarBeans> currentCalendarMap = getTargetCalendarMap(currentCal.get(Calendar.YEAR), currentCal.get(Calendar.MONTH));

        Map<Integer, CalendarBeans> nextCalendarMap = getTargetCalendarMap(nextYear, nextMonth);

        Map<Integer, CalendarBeans> prevCalendarMap = getTargetCalendarMap(prevYear, prevMonth);

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
    public String getTargetMonth(@PathVariable("year") String year, @PathVariable("month") String month) {

        // カレンダー情報
        Map<String, Object> calendarMap = new LinkedHashMap<>();

        Calendar currentCal = Calendar.getInstance();

        // カレンダーの設定（月のみ[0 - 11]で値を取るので注意）
        currentCal.set(Integer.valueOf(year), Integer.valueOf(month) - 1, 1);

        int nextYear = currentCal.get(Calendar.MONTH) == 11 ? currentCal.get(Calendar.YEAR) + 1 : currentCal.get(Calendar.YEAR);
        int nextMonth = currentCal.get(Calendar.MONTH) == 11 ? 0 : currentCal.get(Calendar.MONTH) + 1;
        int prevYear = currentCal.get(Calendar.MONTH) == 0 ? currentCal.get(Calendar.YEAR) - 1 : currentCal.get(Calendar.YEAR);
        int prevMonth = currentCal.get(Calendar.MONTH) == 0 ? 11 : currentCal.get(Calendar.MONTH) - 1;

        Map<Integer, CalendarBeans> currentCalendarMap = getTargetCalendarMap(currentCal.get(Calendar.YEAR), currentCal.get(Calendar.MONTH));

        Map<Integer, CalendarBeans> nextCalendarMap = getTargetCalendarMap(nextYear, nextMonth);

        Map<Integer, CalendarBeans> prevCalendarMap = getTargetCalendarMap(prevYear, prevMonth);

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

    /**
     * 対象月のカレンダーマップを取得
     *
     * @param targetYear    対象の年
     * @param targetMonth   対象の月
     * @return  Map<Integer, CalendarBeans> カレンダーマップオブジェクト
     */
    private Map<Integer, CalendarBeans> getTargetCalendarMap(int targetYear, int targetMonth) {

        Map<Integer, CalendarBeans> targetCalendarMap = new LinkedHashMap<>();

        Calendar targetCal = Calendar.getInstance();

        targetCal.clear();
        targetCal.set(targetYear, targetMonth, 1);

        for (int i = 1; i <= targetCal.getActualMaximum(Calendar.DATE); i++) {
            CalendarBeans calendarBeans = new CalendarBeans();

            targetCal.set(Calendar.DAY_OF_MONTH, i);

            calendarBeans.setDayOfWeek(targetCal.get(Calendar.DAY_OF_WEEK));
            calendarBeans.setDayOfWeekStr(CalendarModel.getDayOfWeekStrJP(targetCal.get(Calendar.DAY_OF_WEEK)));

            targetCalendarMap.put(i, calendarBeans);
        }

        return targetCalendarMap;
    }
}

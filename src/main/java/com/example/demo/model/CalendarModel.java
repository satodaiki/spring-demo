package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarModel {

    public static final int START_SUNDAY = 0;
    public static final int START_MONDAY = 1;

    public static List<String> getDayOfWeek(int startDayOfWeek) {
        List<String> dayOfWeekList = new ArrayList<String>();

        switch (startDayOfWeek) {
            case START_SUNDAY:
            default:
                dayOfWeekList.add("Sun");
                dayOfWeekList.add("Mon");
                dayOfWeekList.add("Tue");
                dayOfWeekList.add("Wed");
                dayOfWeekList.add("Thu");
                dayOfWeekList.add("Fri");
                dayOfWeekList.add("Sut");
        }
        return dayOfWeekList;
    }

    /**
     * 曜日文字列の取得
     *
     * @param dayOfWeek カレンダークラス標準の曜日定数
     * @return
     */
    public static String getDayOfWeekStrJP(int dayOfWeek) {
        String dayOfWeekStr = "";

        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                //日曜日
                dayOfWeekStr = "日曜日";
                break;
            case Calendar.MONDAY:
                //月曜日
                dayOfWeekStr = "月曜日";
                break;
            case Calendar.TUESDAY:
                //火曜日
                dayOfWeekStr = "火曜日";
                break;
            case Calendar.WEDNESDAY:
                //水曜日
                dayOfWeekStr = "水曜日";
                break;
            case Calendar.THURSDAY:
                //木曜日
                dayOfWeekStr = "木曜日";
                break;
            case Calendar.FRIDAY:
                //金曜日
                dayOfWeekStr = "金曜日";
                break;
            case Calendar.SATURDAY:
                //土曜日
                dayOfWeekStr = "土曜日";
                break;
        }

        return dayOfWeekStr;
    }
}

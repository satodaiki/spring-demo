package com.example.demo.model;

import java.util.ArrayList;
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
}

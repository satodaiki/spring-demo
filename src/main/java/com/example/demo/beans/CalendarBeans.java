package com.example.demo.beans;

import lombok.Data;

@Data
public class CalendarBeans {

    /** 曜日（Calendarクラス標準の数値） */
    private int dayOfWeek;

    /** 曜日文字列 */
    private String dayOfWeekStr;

}

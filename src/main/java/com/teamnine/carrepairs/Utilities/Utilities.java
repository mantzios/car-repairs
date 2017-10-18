package com.teamnine.carrepairs.Utilities;

import java.util.Calendar;
import java.util.Date;

public class Utilities {
    private static Calendar calendar=Calendar.getInstance();


    public static Date setStartDate(Date date){
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        return calendar.getTime();
    }

    public static Date setEndDate(Date date){
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        return calendar.getTime();
    }
}

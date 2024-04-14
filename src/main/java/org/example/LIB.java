package org.example;

import java.util.Date;

public class LIB {

    static Integer GetCurrentTimeInSec(Date date) {
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();
        int hourS = hour * 3600;
        int minS = min * 60;
        Integer output = hourS + minS + sec;
        return output;
    }

    static boolean CurrentTimeBetweenBorder(Date date, Integer SecStart, Integer SecEnd) {
//        int hour = date.getHours();
//        int min = date.getMinutes();
//        int sec = date.getSeconds();
//        int hourS = hour * 3600;
//        int minS = min * 60;
        if ((SecStart == null) || (SecEnd == null))
            return false;
        else if (SecStart <= GetCurrentTimeInSec(date) && GetCurrentTimeInSec(date) <= SecEnd)
            return true;

        return false;
    }
}

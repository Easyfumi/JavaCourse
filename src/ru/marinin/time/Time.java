package ru.marinin.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    private int sec;

    private static int timeCalc(int... str1) {
        if (str1.length>3) throw new IllegalArgumentException();
        int time = 0;
        int multiplier = 1;
        for (int i=str1.length-1; i>=0; i--) {
            time = time + str1[i]*multiplier;
            multiplier *= 60;
        }
        return time;
    }

    public Time(int sec) {
        this.sec = sec;
    }
    public Time(int... str1) {
        this(timeCalc(str1));
    }

    private String parseOut(SimpleDateFormat formatterOut) {
        SimpleDateFormat formatterIn = new SimpleDateFormat("ss");
        try {
            Date date = formatterIn.parse(sec+"");
            return  formatterOut.format(date);
        }
        catch (ParseException e) {
            return e.toString();
        }
    }
    public String getSeconds() {
        return parseOut(new SimpleDateFormat("ss"));
    }
    public String getMinutes() {
        return parseOut(new SimpleDateFormat("mm"));
    }
    public String getHour() {
        return parseOut(new SimpleDateFormat("HH"));
    }

    @Override
    public String toString() {
        return parseOut(new SimpleDateFormat("HH:mm:ss"));
    }
}
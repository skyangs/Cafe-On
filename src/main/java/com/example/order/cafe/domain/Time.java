package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.TimeErrorMsg;

public class Time {
    private int hour;
    private  int minute;

    public static final int MIN_HOUR = 0;
    public static final int MAX_HOUR = 23;
    public static final int MIN_MINUTE = 0;
    public static final int MAX_MINUTE = 59;

    public Time(int hour, int minute){
        validation(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    public boolean isHour(int hour){
        return this.hour == hour;
    }

    public void validation(int hour, int minute){
        check_hour(hour);
        check_minute(minute);
    }

    public void check_hour(int hour){

        if(hour < MIN_HOUR || hour > MAX_HOUR){
            throw new IllegalArgumentException(TimeErrorMsg.TIME_HOUR_RANGE_OUT_ERROR_MESSAGE.getValue());
        }
    }

    public void check_minute(int minute){

        if(minute < MIN_MINUTE || minute > MAX_MINUTE){
            throw new IllegalArgumentException(TimeErrorMsg.TIME_MINUTE_RANGE_OUT_ERROR_MESSAGE.getValue());
        }
    }

    public String formatHourAndMinute(int hour, int minute){
        String string_hour = formatHour(hour);
        String string_minute = formatMinute(minute);

        return string_hour + ":" + string_minute;
    }
    public String formatHour(int hour) {
        return (hour < 10) ? "0" + hour : String.valueOf(hour);
    }

    public String formatMinute(int minute) {
        return (minute < 10) ? "0" + minute : String.valueOf(minute);
    }


}

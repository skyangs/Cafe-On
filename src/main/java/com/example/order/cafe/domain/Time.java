package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.TimeErrorMsg;

public class Time {
    private int hour;
    private int minute;

    public static final int MIN_HOUR = 0;
    public static final int MAX_HOUR = 23;
    public static final int MIN_MINUTE = 0;
    public static final int MAX_MINUTE = 59;
    public static final int MAX_HOUR_CHANGE_FORMAT = 10;
    public static final int MAX_MINUTE_CHANGE_FORMAT = 10;
    public static final String STRING_ZERO = "0";
    public static final String COLON = ":";

    public static final int IS_AFTER_HOUR = 1;
    public static final int IS_BEFORE_HOUR = -1;

    public static final int IS_AFTER_MINUTE = 1;
    public static final int IS_BEFORE_MINUTE = -1;
    public static final int IS_EQUAL_MINUTE = 0;

    public Time(int hour, int minute){
        validation(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    public boolean isHour(int hour){
        return this.hour == hour;
    }

    public void validation(int hour, int minute){
        check_hour_range(hour);

        check_minute_range(minute);
    }

    public void check_hour_range(int hour){

        if(hour < MIN_HOUR || hour > MAX_HOUR){
            throw new IllegalArgumentException(TimeErrorMsg.TIME_HOUR_RANGE_OUT_ERROR_MESSAGE.getValue());
        }
    }

    public void check_minute_range(int minute){

        if(minute < MIN_MINUTE || minute > MAX_MINUTE){
            throw new IllegalArgumentException(TimeErrorMsg.TIME_MINUTE_RANGE_OUT_ERROR_MESSAGE.getValue());
        }
    }

    public String formatHourAndMinute(){
        return formatHour(this.hour) + COLON + formatMinute(this.minute);
    }

    public String formatHour(int hour) {
        return (hour < MAX_HOUR_CHANGE_FORMAT) ? STRING_ZERO + hour : String.valueOf(hour);
    }

    public String formatMinute(int minute) {
        return (minute < MAX_MINUTE_CHANGE_FORMAT) ? STRING_ZERO + minute : String.valueOf(minute);
    }

    public int compareTime(Time otherTime){
        return compareHour(otherTime);
    }

    public int compareHour(Time otherTime){

        if (this.hour < otherTime.hour) {
            return IS_BEFORE_HOUR;
        } else if (this.hour > otherTime.hour) {
            return IS_AFTER_HOUR;
        } else {
            return compareMinute(otherTime);
        }

    }

    public int compareMinute(Time otherTime){

        if (this.minute < otherTime.minute) {
            return IS_BEFORE_MINUTE;
        } else if (this.minute > otherTime.minute) {
            return IS_AFTER_MINUTE;
        }

        return IS_EQUAL_MINUTE;
    }

}

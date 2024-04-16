package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.TimeErrorMsg;
import com.example.order.global.common.BaseTimeEntity;
import jakarta.persistence.Entity;

import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Time extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "\"hour\"", nullable = false)
    private final int hour;
    @Column(nullable = false)
    private final int minute;

    @Transient
    public static final int MIN_HOUR = 0;
    @Transient
    public static final int MAX_HOUR = 23;
    @Transient
    public static final int MIN_MINUTE = 0;
    @Transient
    public static final int MAX_MINUTE = 59;
    @Transient
    public static final int MAX_HOUR_CHANGE_FORMAT = 10;
    @Transient
    public static final int MAX_MINUTE_CHANGE_FORMAT = 10;
    @Transient
    public static final String STRING_ZERO = "0";

    @Transient
    public static final String IS_BEFORE_TIME = "이전";
    @Transient
    public static final String IS_AFTER_TIME = "이후";
    @Transient
    public static final String IS_SAME_TIME = "동일";

    private Time(int hour, int minute){
        validation(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    public static Time of(int hour, int minute){
        return new Time(hour, minute);
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
        return formatHour(this.hour) + ":" + formatMinute(this.minute);
    }

    public String formatHour(int hour) {
        return (hour < MAX_HOUR_CHANGE_FORMAT) ? STRING_ZERO + hour : String.valueOf(hour);
    }

    public String formatMinute(int minute) {
        return (minute < MAX_MINUTE_CHANGE_FORMAT) ? STRING_ZERO + minute : String.valueOf(minute);
    }

    public String compareTime(Time otherTime){

        int thisTotalMinute = calculateTotalMinute(this.hour, this.minute);
        int otherTotalMinute = calculateTotalMinute(otherTime.hour, otherTime.minute);

        if (thisTotalMinute < otherTotalMinute){
            return IS_BEFORE_TIME;
        }
        
        if (thisTotalMinute > otherTotalMinute){
            return IS_AFTER_TIME;
        }

        return IS_SAME_TIME;
    }

    public boolean isThisTimeSameAsOtherTime(Time otherTime){
        return Objects.equals(compareTime(otherTime), IS_SAME_TIME);
    }

    public boolean isThisTimeAfterOtherTime(Time otherTime){
        return Objects.equals(compareTime(otherTime), IS_AFTER_TIME);
    }

    public int calculateTotalMinute(int hour, int minute){
        return hour * 60 + minute;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }
}

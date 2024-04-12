package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimeErrorMsg;

import java.util.Objects;

public class OperationTime {
    private final Time open;
    private final Time close;

    public static final String IS_BEFORE_TIME = "이전";
    public static final String IS_AFTER_TIME = "이후";
    public static final String IS_SAME_TIME = "동일";
    public static final String DAY_OFF = "휴무";

    private OperationTime(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public static OperationTime of(Time open, Time close){
        return new OperationTime(open, close);
    }

    public boolean isOpen(Time open){
        return this.open.equals(open);
    }

    public boolean isClose(Time close){
        return this.close.equals(close);
    }

    public String makeOperationTimeList(){
        if(isOpenSameAsClose()){
            return checkOpenTimeIsSameCloseTime();
        } else if(isOpenAfterClose()){
            throw new IllegalArgumentException(OperationTimeErrorMsg.OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG.getValue());
        }

        return formatOperationTime();
    }

    public boolean isOpenSameAsClose(){
        return Objects.equals(this.open.compareTime(this.close), IS_SAME_TIME);
    }

    public String checkOpenTimeIsSameCloseTime(){
        return DAY_OFF;
    }

    public boolean isOpenAfterClose(){
        return Objects.equals(this.open.compareTime(this.close), IS_AFTER_TIME);
    }

    public String formatOperationTime(){
        return this.open.formatHourAndMinute() + " - " + this.close.formatHourAndMinute();
    }

    public Time getOpen(){
        return open;
    }

    public Time getClose(){
        return close;
    }
}

package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimeErrorMsg;

public class OperationTime {
    private Time open;
    private Time close;

    public static final int OPEN_IS_BEFORE_CLOSE_VALUE = -1;
    public static final String HYPHEN = " - ";

    public OperationTime(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public boolean isOpen(Time open){
        return this.open.equals(open);
    }

    public boolean isClose(Time close){
        return this.close.equals(close);
    }

    public void CheckOpenTimeIsFasterThanCloseTime(){
        if(this.open.compareTime(this.close) > OPEN_IS_BEFORE_CLOSE_VALUE){
            throw new IllegalArgumentException(OperationTimeErrorMsg.OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG.getValue());
        }

    }

    public String formatOperationTime(){
        return this.open.formatHourAndMinute() + HYPHEN + this.close.formatHourAndMinute();
    }

}

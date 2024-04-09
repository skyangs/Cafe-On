package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimeErrorMsg;

public class OperationTime {
    private Time open;
    private Time close;

    public static final int OPEN_IS_BEFORE_CLOSE_VALUE = -1;
    public static final int OPEN_IS_AFTER_CLOSE_VALUE = 1;
    public static final String HYPHEN = " - ";
    public static final String DAY_OFF = "휴무";

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

    public String makeOperationTimeList(){
        if(isOpenSameAsClose()){
            return CheckOpenTimeIsSameCloseTime();
        } else if(isOpenAfterClose()){
            throw new IllegalArgumentException(OperationTimeErrorMsg.OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG.getValue());
        }

        return formatOperationTime();
    }

    public boolean isOpenSameAsClose(){
        return this.open.compareTime(this.close) == 0;
    }

    public String CheckOpenTimeIsSameCloseTime(){
        return DAY_OFF;
    }

    public boolean isOpenAfterClose(){
        return this.open.compareTime(this.close) == OPEN_IS_AFTER_CLOSE_VALUE;
    }

    public String formatOperationTime(){
        return this.open.formatHourAndMinute() + HYPHEN + this.close.formatHourAndMinute();
    }

}

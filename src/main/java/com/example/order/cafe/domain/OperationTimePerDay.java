package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimePerDayErrorMsg;

public class OperationTimePerDay {

    private Days days;
    private OperationTime operationTime;

    public OperationTimePerDay(Days days, OperationTime operationTime){
        validation(operationTime);
        this.days = days;
        this.operationTime = operationTime;
    }

    public void validation(OperationTime operationTime){
        if(operationTime == null){
            throw new IllegalArgumentException(OperationTimePerDayErrorMsg.OPERATION_TIME_NON_NULL_ERROR_MSG.getValue());
        }
    }

    public void isDuplicate(Days days){
            if(this.days == days){
                throw new IllegalArgumentException(OperationTimePerDayErrorMsg.BUSINESS_HOURS_NOT_DUPLICATE_DAY_ERROR_MESSAGE.getValue());
            }
    }

    public Days getDays(){
        return this.days;
    }

    public OperationTime getOperationTime(){
        return this.operationTime;
    }
}

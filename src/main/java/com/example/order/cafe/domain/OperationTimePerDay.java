package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimePerDayErrorMsg;

public class OperationTimePerDay {

    private final Days days;
    private final OperationTime operationTime;

    private OperationTimePerDay(Days days, OperationTime operationTime){
        validation(operationTime);
        this.days = days;
        this.operationTime = operationTime;
    }

    public static OperationTimePerDay of(Days days, OperationTime operationTime){
        return new OperationTimePerDay(days, operationTime);
    }

    public void validation(OperationTime operationTime){
        if(operationTime == null){
            throw new IllegalArgumentException(OperationTimePerDayErrorMsg.OPERATION_TIME_NON_NULL_ERROR_MSG.getValue());
        }
    }

    public Days getDays(){
        return days;
    }

    public OperationTime getOperationTime(){
        return operationTime;
    }
}

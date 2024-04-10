package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.BusinessHoursErrorMsg;

import java.util.ArrayList;
import java.util.List;

public class BusinessHours {
    private final List<OperationTimePerDay> operationTimeList;

    public static final int OPERATION_TIME_PER_DAY_SIZE = 7;

    public BusinessHours(List<OperationTimePerDay> operationTimeList){
        validation(operationTimeList);
        this.operationTimeList = operationTimeList;
    }


    public void validation(List<OperationTimePerDay> operationTimePerDay){

        checkOperationTimeList_length(operationTimePerDay);

        isDuplicateDay();
    }

    public void checkOperationTimeList_length(List<OperationTimePerDay> operationTimePerDay){
        if(operationTimePerDay.size() != OPERATION_TIME_PER_DAY_SIZE){
            throw new IllegalArgumentException(BusinessHoursErrorMsg.OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG.getValue());
        }
    }

    public void isDuplicateDay(){
        for (OperationTimePerDay operationTimePerDay : this.operationTimeList) {
        }
    }

    public String getTimePerDay(Days day){
        return operationTimeList.get(day.ordinal()).getOperationTime().makeOperationTimeList();
    }

}
package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.BusinessHoursErrorMsg;

import java.util.List;

public class BusinessHours {

    private final List<OperationTimePerDay> operationTimeList;

    public static final int DISTINCT_DAY_SIZE = 7;

    public BusinessHours(List<OperationTimePerDay> operationTimeList){
        validation(operationTimeList);
        this.operationTimeList = operationTimeList;
    }

    public void validation(List<OperationTimePerDay> operationTimePerDay){

        checkOperationTimeList_length(isDuplicateDay(operationTimePerDay));

    }

    public List<Days> isDuplicateDay(List<OperationTimePerDay> operationTimePerDay){

        return operationTimePerDay.stream()
                .map(OperationTimePerDay::getDays)
                .distinct()
                .toList();

    }

    public void checkOperationTimeList_length(List<Days> daysList){
        if(daysList.size() != DISTINCT_DAY_SIZE){
            throw new IllegalArgumentException(BusinessHoursErrorMsg.OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG.getValue());
        }
    }

    public String getTimePerDay(Days day){
        return operationTimeList.get(day.ordinal()).getOperationTime().makeOperationTimeList();
    }

}
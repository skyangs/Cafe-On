package com.example.order.cafe.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursUpdateRequest {

    private final List<OperationTimePerDayUpdateRequest> operationTimeList;

    public BusinessHoursUpdateRequest(List<OperationTimePerDayUpdateRequest> operationTimeList){
        this.operationTimeList = operationTimeList;
    }

}

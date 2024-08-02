package com.example.order.cafe.service.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursResponse {

    private final List<OperationTimePerDayResponse> operationTimeList;

    public BusinessHoursResponse(List<OperationTimePerDayResponse> operationTimeList){
        this.operationTimeList = operationTimeList;
    }

}

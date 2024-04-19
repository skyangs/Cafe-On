package com.example.order.cafe.dto.request;

import lombok.Getter;

@Getter
public class OperationTimePerDayRequest {
    private final DaysRequest days;
    private final OperationTimeRequest operationTimeRequest;

    public OperationTimePerDayRequest(DaysRequest days, OperationTimeRequest operationTimeRequest){
        this.days = days;
        this.operationTimeRequest = operationTimeRequest;
    }

}

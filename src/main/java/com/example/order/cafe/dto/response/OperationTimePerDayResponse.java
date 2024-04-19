package com.example.order.cafe.dto.response;

import lombok.Getter;

@Getter
public class OperationTimePerDayResponse {
    private final String day;
    private final OperationTimeResponse operationTime;

    public OperationTimePerDayResponse(String day, OperationTimeResponse operationTime){
        this.day = day;
        this.operationTime = operationTime;
    }

}

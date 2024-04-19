package com.example.order.cafe.dto.request;

import lombok.Getter;

@Getter
public class OperationTimePerDayUpdateRequest {
    private final OperationTimeRequest operationTime;

    public OperationTimePerDayUpdateRequest(OperationTimeRequest operationTime){
        this.operationTime = operationTime;
    }

}

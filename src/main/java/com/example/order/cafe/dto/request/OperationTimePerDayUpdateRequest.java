package com.example.order.cafe.dto.request;

import lombok.Getter;

@Getter
public class OperationTimePerDayUpdateRequest {
    private final long id;
    private final OperationTimeRequest operationTime;

    public OperationTimePerDayUpdateRequest(long id, OperationTimeRequest operationTime){
        this.id = id;
        this.operationTime = operationTime;
    }

}

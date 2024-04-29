package com.example.order.cafe.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OperationTimePerDayRequest {
    @NotNull
    private final DaysRequest days;
    @NotNull
    private final OperationTimeRequest operationTime;

    public OperationTimePerDayRequest(DaysRequest days, OperationTimeRequest operationTime){
        this.days = days;
        this.operationTime = operationTime;
    }

}

package com.example.order.cafe.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OperationTimePerDayRequest {
    @NotNull
    private final DaysRequest days;
    @NotNull
    private final OperationTimeRequest operationTimeRequest;

    public OperationTimePerDayRequest(DaysRequest days, OperationTimeRequest operationTimeRequest){
        this.days = days;
        this.operationTimeRequest = operationTimeRequest;
    }

}

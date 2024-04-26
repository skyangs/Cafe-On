package com.example.order.cafe.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OperationTimePerDayUpdateRequest {

    @Min(1)
    private final long id;
    @NotNull
    private final OperationTimeRequest operationTime;

    public OperationTimePerDayUpdateRequest(long id, OperationTimeRequest operationTime){
        this.id = id;
        this.operationTime = operationTime;
    }

}

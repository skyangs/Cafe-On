package com.example.order.cafe.dto.response;

import com.example.order.cafe.domain.Days;
import lombok.Getter;

@Getter
public class OperationTimePerDayResponse {
    private final Days days;
    private final OperationTimeResponse operationTime;
    private final long businessHoursId;
    public OperationTimePerDayResponse(Days days, OperationTimeResponse operationTime, long businessHoursId){
        this.days = days;
        this.operationTime = operationTime;
        this.businessHoursId = businessHoursId;
    }

}

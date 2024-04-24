package com.example.order.cafe.dto.response;

import com.example.order.cafe.domain.Days;
import lombok.Getter;

@Getter
public class OperationTimePerDayResponse {
    private final Days day;
    private final OperationTimeResponse operationTime;
    private final long businessHoursId;
    public OperationTimePerDayResponse(Days day, OperationTimeResponse operationTime, long businessHoursId){
        this.day = day;
        this.operationTime = operationTime;
        this.businessHoursId = businessHoursId;
    }

}

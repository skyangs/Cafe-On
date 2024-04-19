package com.example.order.cafe.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursUpdateRequest {

    private final List<OperationTimePerDayUpdateRequest> operationTimePerDayUpdateRequests;

    public BusinessHoursUpdateRequest(List<OperationTimePerDayUpdateRequest> operationTimePerDayUpdateRequests){
        this.operationTimePerDayUpdateRequests = operationTimePerDayUpdateRequests;
    }

}

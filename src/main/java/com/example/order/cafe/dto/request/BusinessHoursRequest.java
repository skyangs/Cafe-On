package com.example.order.cafe.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursRequest {

    @Size(min = 7, max = 7)
    private final List<OperationTimePerDayRequest> operationTimePerDayList;

    public BusinessHoursRequest(List<OperationTimePerDayRequest> operationTimePerDayList){
        this.operationTimePerDayList = operationTimePerDayList;
    }

}

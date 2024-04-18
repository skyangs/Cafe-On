package com.example.order.cafe.dto.request;

import com.example.order.cafe.domain.OperationTimePerDay;
import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursRequest {

    private final List<OperationTimePerDayRequest> operationTimeList;

    public BusinessHoursRequest(List<OperationTimePerDayRequest> operationTimeList){
        this.operationTimeList = operationTimeList;
    }

}

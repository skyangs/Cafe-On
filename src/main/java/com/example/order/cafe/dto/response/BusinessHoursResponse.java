package com.example.order.cafe.dto.response;

import com.example.order.cafe.domain.OperationTimePerDay;
import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursResponse {

    private final List<OperationTimePerDayResponse> operationTimeList;

    public BusinessHoursResponse(List<OperationTimePerDayResponse> operationTimeList){
        this.operationTimeList = operationTimeList;
    }

}

package com.example.order.cafe.dto.request;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.List;

@Getter
public class BusinessHoursUpdateRequest {

    @Size(min = 7, max = 7)
    private final List<OperationTimePerDayUpdateRequest> operationTimeList;

    public BusinessHoursUpdateRequest(List<OperationTimePerDayUpdateRequest> operationTimeList){
        this.operationTimeList = operationTimeList;
    }

}

package com.example.order.cafe.service.dto.request;

import jakarta.validation.constraints.Size;

import java.util.List;

public record BusinessHoursUpdateRequest(
        @Size(min = 7, max = 7) List<OperationTimePerDayUpdateRequest> operationTimePerDayList
){}

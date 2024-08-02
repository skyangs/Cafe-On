package com.example.order.cafe.service.dto.request;


import jakarta.validation.constraints.Size;

import java.util.List;

public record BusinessHoursRequest(
        @Size(min = 7, max = 7) List<OperationTimePerDayRequest> operationTimePerDayList
) {}

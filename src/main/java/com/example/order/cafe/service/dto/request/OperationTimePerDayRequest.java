package com.example.order.cafe.service.dto.request;

import jakarta.validation.Valid;

public record OperationTimePerDayRequest(
        @Valid DaysRequest days,
        @Valid OperationTimeRequest operationTime
){}

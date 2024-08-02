package com.example.order.cafe.service.dto.request;

import jakarta.validation.Valid;

public record OperationTimePerDayUpdateRequest(
        @Valid DaysUpdateRequest days,
        @Valid OperationTimeUpdateRequest operationTime
) {}

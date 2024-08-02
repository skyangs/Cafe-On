package com.example.order.cafe.service.dto.request;

import jakarta.validation.Valid;

public record OperationTimeUpdateRequest(
        @Valid TimeUpdateRequest open,
        @Valid TimeUpdateRequest close
){}

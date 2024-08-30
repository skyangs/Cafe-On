package com.example.order.cafe.service.dto.request;

import jakarta.validation.Valid;

public record OperationTimeRequest(
        @Valid TimeRequest open,
        @Valid TimeRequest close
){}

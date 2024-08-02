package com.example.order.cafe.service.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TimeRequest(
        @Min(0) @Max(23) int hour,
        @Min(0) @Max(59) int minute
){}

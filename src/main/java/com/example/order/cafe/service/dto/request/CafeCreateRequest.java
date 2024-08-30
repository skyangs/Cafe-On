package com.example.order.cafe.service.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CafeCreateRequest(
        @Valid CafeInfoCreateRequest cafeInfo,
        @Valid BusinessHoursRequest businessHours
){}

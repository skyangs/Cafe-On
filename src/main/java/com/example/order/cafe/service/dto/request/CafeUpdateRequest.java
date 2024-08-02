package com.example.order.cafe.service.dto.request;

import jakarta.validation.Valid;

public record CafeUpdateRequest(
        @Valid CafeInfoUpdateRequest cafeInfo,
        @Valid BusinessHoursUpdateRequest businessHours
){}

package com.example.order.cafe.service.dto.request;

import com.example.order.cafe.domain.Days;
import jakarta.validation.constraints.NotBlank;

public record DaysRequest(
        @NotBlank(message = "요일은 필수 입력 값 입니다.") Days days
){}

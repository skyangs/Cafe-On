package com.example.order.cafe.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CafeInfoCreateRequest(
        @NotBlank(message = "이름은 필수 입력 값 입니다.") String name,
        String explain,
        @NotBlank(message = "연락처는 숫자만 입력할 수 있습니다.")
        @Size(min = 9, max = 11)
        @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "카페 연락처는 000-0000-0000 형식이어야 합니다.") String contactNumber,
        @NotBlank(message = "주소은 필수 입력 값 입니다.") String address
){}

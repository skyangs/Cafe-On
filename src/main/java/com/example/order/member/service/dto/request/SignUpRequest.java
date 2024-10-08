package com.example.order.member.service.dto.request;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Grade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
        @NotBlank(message = "아이디는 필수 입력 값 입니다.")
        @Size(min = 4, max = 10, message = "아이디는 4-10자여야 합니다.")
        @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$", message = "아이디는 영문과 숫자로 이루어져야 합니다.") String memberId,
        @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
        @Size(min = 8, max = 15, message = "비밀번호는 8-15자여야 합니다.") String password,
        @NotBlank(message = "이름은 필수 입력 값 입니다.")
        @Size(min = 1, max = 5, message = "이름은 1-5자여야 합니다.") String name,
        @NotNull(message = "권한은 필수 입력 값 입니다.") AuthType authType,
        @NotBlank(message = "휴대폰 번호는 필수 입력 값 입니다.")
        @Size(min = 9, max = 11, message = "휴대폰 번호는 9-11자여야 합니다.")
        @Pattern(regexp = "^\\d+$", message = "휴대폰 번호는 숫자로 이루어져야 합니다.") String phoneNum,
        @NotNull(message = "등급은 필수 입력 값 입니다.") Grade grade
) {
}

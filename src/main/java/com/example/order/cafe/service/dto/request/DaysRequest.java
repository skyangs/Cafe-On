package com.example.order.cafe.service.dto.request;

import com.example.order.cafe.domain.Days;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class DaysRequest {

    @NotBlank(message = "요일은 필수 입력 값입니다.")
    private final Days days;

    public DaysRequest(Days days){
        this.days = days;
    }

}

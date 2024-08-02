package com.example.order.cafe.service.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class TimeRequest {

    @Min(0) @Max(23)
    private final int hour;
    @Min(0) @Max(59)
    private final int minute;

    public TimeRequest(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}

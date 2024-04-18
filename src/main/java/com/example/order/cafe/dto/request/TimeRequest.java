package com.example.order.cafe.dto.request;

import lombok.Getter;

@Getter
public class TimeRequest {

    private final int hour;
    private final int minute;

    public TimeRequest(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}

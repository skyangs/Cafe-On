package com.example.order.cafe.dto.response;

import lombok.Getter;

@Getter
public class TimeResponse {

    private final int hour;
    private final int minute;

    public TimeResponse(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}

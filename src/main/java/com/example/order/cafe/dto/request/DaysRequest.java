package com.example.order.cafe.dto.request;

import com.example.order.cafe.domain.Days;
import lombok.Getter;

@Getter
public class DaysRequest {

    private final Days dayOfWeek;

    public DaysRequest(Days dayOfWeek){
        this.dayOfWeek = dayOfWeek;
    }

}

package com.example.order.cafe.service.dto.response;

import lombok.Getter;

@Getter
public class TemperatureOptionResponse {

    private final String option;

    public TemperatureOptionResponse(String option){
        this.option = option;
    }
}

package com.example.order.cafe.dto.request;

import lombok.Getter;

@Getter
public class OperationTimeRequest {

    private final TimeRequest open;
    private final TimeRequest close;

    public OperationTimeRequest(TimeRequest open, TimeRequest close){
        this.open = open;
        this.close = close;
    }

}

package com.example.order.cafe.service.dto.response;

import lombok.Getter;

@Getter
public class OperationTimeResponse {

    private final TimeResponse open;
    private final TimeResponse close;

    public OperationTimeResponse(TimeResponse open, TimeResponse close){
        this.open = open;
        this.close = close;
    }

}

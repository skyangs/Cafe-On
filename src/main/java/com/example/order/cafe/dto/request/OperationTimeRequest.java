package com.example.order.cafe.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class OperationTimeRequest {

    @NotNull
    private final TimeRequest open;
    @NotNull
    private final TimeRequest close;

    public OperationTimeRequest(TimeRequest open, TimeRequest close){
        this.open = open;
        this.close = close;
    }

}

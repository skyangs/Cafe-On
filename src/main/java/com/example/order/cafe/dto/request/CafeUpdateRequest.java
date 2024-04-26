package com.example.order.cafe.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CafeUpdateRequest {
    @NotNull
    private final CafeInfoUpdateRequest cafeInfo;
    @NotNull
    private final BusinessHoursUpdateRequest businessHours;

    public CafeUpdateRequest(CafeInfoUpdateRequest cafeInfo, BusinessHoursUpdateRequest businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

}

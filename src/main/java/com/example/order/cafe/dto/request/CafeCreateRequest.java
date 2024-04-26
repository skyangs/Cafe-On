package com.example.order.cafe.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CafeCreateRequest {
    @NotNull
    private final CafeInfoCreateRequest cafeInfo;
    @NotNull
    private final BusinessHoursRequest businessHours;

    public CafeCreateRequest(CafeInfoCreateRequest cafeInfo, BusinessHoursRequest businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

}

package com.example.order.cafe.dto.request;


import lombok.Getter;

@Getter
public class CafeCreateRequest {
    private final CafeInfoRequest cafeInfo;
    private final BusinessHoursRequest businessHours;

    public CafeCreateRequest(CafeInfoRequest cafeInfo, BusinessHoursRequest businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

}

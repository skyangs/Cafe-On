package com.example.order.cafe.dto.request;


import lombok.Getter;

@Getter
public class CafeUpdateRequest {
    private final CafeInfoRequest cafeInfo;
    private final BusinessHoursUpdateRequest businessHours;

    public CafeUpdateRequest(CafeInfoRequest cafeInfo, BusinessHoursUpdateRequest businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

}

package com.example.order.cafe.service.dto.response;

import lombok.Getter;

@Getter
public class CafeResponse {
    private final CafeInfoResponse cafeInfo;
    private final BusinessHoursResponse businessHours;

    public CafeResponse(CafeInfoResponse cafeInfo, BusinessHoursResponse businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

}

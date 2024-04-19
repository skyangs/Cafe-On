package com.example.order.cafe.dto.request;


import lombok.Getter;

@Getter
public class CafeCreateRequest {
    private final CafeInfoRequest cafeInfoRequest;
    private final BusinessHoursRequest businessHoursRequest;

    public CafeCreateRequest(CafeInfoRequest cafeInfoRequest, BusinessHoursRequest businessHoursRequest){
        this.cafeInfoRequest = cafeInfoRequest;
        this.businessHoursRequest = businessHoursRequest;
    }

}

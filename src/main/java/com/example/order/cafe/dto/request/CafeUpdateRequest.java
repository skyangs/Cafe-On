package com.example.order.cafe.dto.request;


import lombok.Getter;

@Getter
public class CafeUpdateRequest {
    private final CafeInfoRequest cafeInfoRequest;
    private final BusinessHoursUpdateRequest businessHoursUpdateRequest;

    public CafeUpdateRequest(CafeInfoRequest cafeInfoRequest, BusinessHoursUpdateRequest businessHoursUpdateRequest){
        this.cafeInfoRequest = cafeInfoRequest;
        this.businessHoursUpdateRequest = businessHoursUpdateRequest;
    }

}

package com.example.order.cafe.fixture;

import com.example.order.cafe.dto.request.CafeCreateRequest;

public class CafeFixture {

    public static CafeCreateRequest 카페_등록_REQUEST_DTO(){
        return new CafeCreateRequest(CafeInfoFixture.카페프로필_REQUEST_DTO(),
                BusinessHoursFixture.카페운영시간_REQUEST_DTO());
    }



}

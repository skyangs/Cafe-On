package com.example.order.cafe.service.dto.response;

import com.example.order.member.domain.AuthType;
import lombok.Getter;

@Getter
public class CafeInfoResponse {

    private final String name;
    private final String explain;
    private final String contactNumber;
    private final String address;

    public CafeInfoResponse(String name, String explain, String contactNumber, String address){
        this.name = name;
        this.explain = explain;
        this.contactNumber = contactNumber;
        this.address = address;
    }

}

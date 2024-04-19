package com.example.order.cafe.dto.request;

import lombok.Getter;

@Getter
public class CafeInfoRequest {

    private final String name;
    private final String explain;
    private final String contactNumber;
    private final String address;

    public CafeInfoRequest(String name, String explain, String contactNumber, String address){
        this.name = name;
        this.explain = explain;
        this.contactNumber = contactNumber;
        this.address = address;
    }

}

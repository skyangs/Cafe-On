package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.CafeErrorMsg;
import lombok.Getter;

@Getter
public class CafeInfo {
    private String name;
    private String explain;
    private String contactNumber;
    private String address;

    private int MIN_NAME_LENGTH = 1;

    public CafeInfo(String name, String explain, String contactNumber, String address){
        validation(name);
        this.name = name;
        this.explain = explain;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    private void validation(String name){
        if(name.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(CafeErrorMsg.CAFE_NAME_LENGTH_ERROR_MESSAGE.getValue());

        }
    }



}

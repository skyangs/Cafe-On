package com.example.order.cafe.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Cafe {

    private CafeInfo cafeInfo;

    private BusinessHours businessHours;

    public Cafe(CafeInfo cafeInfo, BusinessHours businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

    public Cafe enrollCafe(CafeInfo cafeInfo, BusinessHours businessHours){
        return new Cafe(cafeInfo, businessHours);
    }

    public void editCafe(CafeInfo cafeInfo, BusinessHours businessHours){
        editCafeInfo(cafeInfo);
        editBusinessHours(businessHours);
    }

    public void editCafeInfo(CafeInfo cafeInfo){
        this.cafeInfo = cafeInfo;
    }

    public void editBusinessHours(BusinessHours businessHours){
        this.businessHours = businessHours;
    }
}

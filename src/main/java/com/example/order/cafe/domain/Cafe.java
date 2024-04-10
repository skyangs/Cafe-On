package com.example.order.cafe.domain;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Cafe {

    private CafeInfo cafeInfo;

    private BusinessHours businessHours;

    public Cafe(CafeInfo cafeInfo, BusinessHours businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cafe cafe = (Cafe) o;
        return Objects.equals(cafeInfo, cafe.cafeInfo) && Objects.equals(businessHours, cafe.businessHours);
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

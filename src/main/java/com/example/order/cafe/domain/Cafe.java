package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.CafeErrorMsg;
import com.example.order.global.common.BaseTimeEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Cafe extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private final CafeInfo cafeInfo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private final BusinessHours businessHours;

    private Cafe(CafeInfo cafeInfo, BusinessHours businessHours){
        validation(cafeInfo, businessHours);
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

    public static Cafe of(CafeInfo cafeInfo, BusinessHours businessHours){
        return new Cafe(cafeInfo, businessHours);
    }

    public void validation(CafeInfo cafeInfo, BusinessHours businessHours){

        isCafeInfoNull(cafeInfo);
        isBusinessHoursNull(businessHours);
    }

    public void isCafeInfoNull(CafeInfo cafeInfo){
        if(cafeInfo == null){
            throw new IllegalArgumentException(CafeErrorMsg.CAFE_INFO_NULL_ERROR_MESSAGE.getValue());
        }
    }

    public void isBusinessHoursNull(BusinessHours businessHours){
        if(businessHours == null){
            throw new IllegalArgumentException(CafeErrorMsg.BUSINESS_HOURS_NULL_ERROR_MESSAGE.getValue());
        }
    }
    public CafeInfo getCafeInfo(){
        return CafeInfo.of(cafeInfo.getName(), cafeInfo.getExplain(), cafeInfo.getContactNumber(), cafeInfo.getAddress());
    }

    public BusinessHours getBusinessHours(){
        return BusinessHours.of(businessHours.getOperationTimeList());
    }

    public Cafe updateCafe(CafeInfo updateCafeInfo, BusinessHours updateBusinessHours){
        return new Cafe(updateCafeInfo, updateBusinessHours);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cafe cafe = (Cafe) o;
        return Objects.equals(cafeInfo, cafe.cafeInfo) &&
                Objects.equals(businessHours, cafe.businessHours);
    }
}

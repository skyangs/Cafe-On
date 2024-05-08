package com.example.order.discount;

import com.example.order.member.domain.Grade;

public class DiscountGrade implements DiscountPolicy{
    private final double VIP_DISCOUNT = 0.2;
    private final double GOLD_DISCOUNT = 0.1;
    private final double SILVER_DISCOUNT = 0.05;

    @Override
    public int discount(Grade grade, int price) {

        if(grade == Grade.VIP)
            return (int) (price * VIP_DISCOUNT);

        if(grade == Grade.GOLD)
            return (int) (price * GOLD_DISCOUNT);

        return (int) (price * SILVER_DISCOUNT);
    }
}

package com.example.order.discount;

import org.springframework.stereotype.Component;

@Component
public class VipDiscountPolicy implements DiscountPolicy{
    private static final double VIP_DISCOUNT_RATE = 0.2;

    @Override
    public int discount(int price) {
        return (int) (price * VIP_DISCOUNT_RATE);
    }
}

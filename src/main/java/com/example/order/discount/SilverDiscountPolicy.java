package com.example.order.discount;


import org.springframework.stereotype.Component;

@Component
public class SilverDiscountPolicy implements DiscountPolicy {
    private static final double SILVER_DISCOUNT_RATE = 0.05;

    @Override
    public int discount(int price) {
        return (int) (price * SILVER_DISCOUNT_RATE);
    }

}

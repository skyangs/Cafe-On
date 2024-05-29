package com.example.order.discount;


import org.springframework.stereotype.Component;

@Component
public class GoldDiscountPolicy implements DiscountPolicy{
    private static final double GOLD_DISCOUNT_RATE = 0.1;

    @Override
    public int discount(int price) {
        return (int) (price * GOLD_DISCOUNT_RATE);
    }
}

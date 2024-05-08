package com.example.order.discount;

import com.example.order.member.domain.Grade;

public interface DiscountPolicy {

    int discount(Grade grade, int price);
}

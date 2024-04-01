package com.example.order.order.domain;

import com.example.order.cafe.domain.Cafe;
import com.example.order.member.domain.Member;

public class Order {
    private Member member;
    private Cafe cafe;

    public Order(Member member, Cafe cafe){
        this.member = member;
        this.cafe = cafe;
    }
}

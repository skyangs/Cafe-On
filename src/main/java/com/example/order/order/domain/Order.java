package com.example.order.order.domain;

import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeMenu;
import com.example.order.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeId")
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeMenuId")
    private CafeMenu cafeMenu;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int discountPrice;

    private Order(Member member, Cafe cafe, CafeMenu cafeMenu, int amount, int discountPrice){
        this.member = member;
        this.cafe = cafe;
        this.cafeMenu = cafeMenu;
        this.amount = amount;
        this.discountPrice = discountPrice;
    }

    public static Order of(Member member, Cafe cafe, CafeMenu cafeMenu, int amount, int discountPrice){
        return new Order(member, cafe, cafeMenu, amount, discountPrice);
    }
}

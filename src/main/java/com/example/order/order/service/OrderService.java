package com.example.order.order.service;

import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeMenu;
import com.example.order.discount.DiscountGrade;
import com.example.order.discount.DiscountPolicy;
import com.example.order.member.domain.Member;
import com.example.order.order.domain.Order;
import com.example.order.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy = new DiscountGrade();

    @Transactional
    public void createOrder(Member member, Cafe cafe, CafeMenu cafeMenu, int amount){

        int orderPrice = cafeMenu.getPrice() * amount;
        int discountPrice = discountPolicy.discount(member.getGrade(), orderPrice);

        Order order = Order.of(member, cafe, cafeMenu, amount, discountPrice);
        orderRepository.save(order);
    }
}

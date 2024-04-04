package com.example.order.cafe.service;

import com.example.order.cafe.domain.Cafe;
import com.example.order.member.domain.Cart;
import com.example.order.member.domain.Member;
import com.example.order.member.dto.CartRequest;
import com.example.order.member.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {

    private MemberRepository memberRepository;
    private CartRepository cartRepository;
    private CafeRepository cafeRepository;
    private Cart cart;

    public void addCart(long memberId, CartRequest cartRequest){
        Member member = memberRepository.findById(memberId);

        List<Cart> cartList = cartRepository.findByMember(member);

        Cafe cafe = cafeRepository.findById(cartRequest.getCafeId());

        Cart cart1 = cart.addMenu(cartList, cafe);
//        boolean checkCafe = cartList.stream().allMatch(cart -> cart.getCafe().equals(cafe));
//        if(!checkCafe) {
//            cartRepository.deleteAll(cartList);
//        }
//        cart.addMenu(new Cart(member,cafe, '카페메뉴', "카페옵션", 2));
        cartRepository.save(cart1);



    }


}

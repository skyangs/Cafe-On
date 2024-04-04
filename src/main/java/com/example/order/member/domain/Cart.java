package com.example.order.member.domain;

import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.domain.CafeMenu;
import com.example.order.cafe.errorMsg.CafeErrorMsg;
import com.example.order.member.errorMsg.MemberErrorMsg;
import com.example.order.member.repository.CartRepository;
import lombok.Getter;

import java.util.List;

@Getter
public class Cart {

    private Member member;
    private Cafe cafe;
    private CafeMenu cafeMenu;
    private CafeMenuOption cafeMenuOption;
    private int amount;

    private int MIN_AMOUNT_LENGTH = 0;

    public Cart(Member member, Cafe cafe, CafeMenu cafeMenu, CafeMenuOption cafeMenuOption,  int amount){
        validation(cafe, cafeMenu, amount);
        this.member = member;
        this.cafe = cafe;
        this.cafeMenu = cafeMenu;
        this.cafeMenuOption = cafeMenuOption;
        this.amount = amount;
    }

    private void validation(Cafe cafe, CafeMenu cafeMenu, int amount) {
        validate_amount(amount);
    }

    private void validate_amount(int amount){
        if(amount < MIN_AMOUNT_LENGTH){
            throw new IllegalArgumentException(MemberErrorMsg.AMOUNT_UNDER_ZERO_ERROR_MESSAGE.getValue());
        }
    }

    private CartRepository cartRepository;

    public Cart addMenu(List<Cart> cartList, Cafe cafe){
        boolean checkCafe = cartList.stream().allMatch(cart -> cart.getCafe().equals(cafe));

        if(!checkCafe) {
            cartRepository.deleteAll(cartList);
        }

        return new Cart(member,cafe, '카페메뉴', "카페옵션", 2);
    }

}

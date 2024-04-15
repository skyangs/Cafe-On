package com.example.order.member.domain;

import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeMenu;
import com.example.order.member.errorMsg.CartErrorMsg;
import lombok.Getter;

import java.util.Objects;

public class Cart {

    private final Member member;
    private final Cafe cafe;
    private final CafeMenu cafeMenu;
    @Getter
    private final int amount;

    private int MIN_AMOUNT_LENGTH = 0;

    private Cart(Member member, Cafe cafe, CafeMenu cafeMenu, int amount){
        validation(member, cafe, cafeMenu, amount);
        this.member = member;
        this.cafe = cafe;
        this.cafeMenu = cafeMenu;
        this.amount = amount;
    }

    public static Cart of(Member member, Cafe cafe, CafeMenu cafeMenu, int amount){
        return new Cart(member, cafe, cafeMenu, amount);
    }

    private void validation(Member member, Cafe cafe, CafeMenu cafeMenu, int amount) {
        isMemberNull(member);
        isCafeNull(cafe);
        isCafeMenuNull(cafeMenu);
        validate_amount(amount);
    }

    private void isMemberNull(Member member){
        if(member == null){
            throw new NullPointerException(CartErrorMsg.MEMBER_IS_NULL_ERROR_MESSAGE.getValue());
        }
    }

    private void isCafeNull(Cafe cafe){
        if(cafe == null){
            throw new NullPointerException(CartErrorMsg.CAFE_IS_NULL_ERROR_MESSAGE.getValue());
        }
    }

    private void isCafeMenuNull(CafeMenu cafeMenu){
        if(cafeMenu == null){
            throw new NullPointerException(CartErrorMsg.CAFE_MENU_IS_NULL_ERROR_MESSAGE.getValue());
        }
    }
    
    private void validate_amount(int amount){
        if(amount < MIN_AMOUNT_LENGTH){
            throw new IllegalArgumentException(CartErrorMsg.AMOUNT_UNDER_ZERO_ERROR_MESSAGE.getValue());
        }
    }

    public boolean compareCafe(Cafe cafe){
        return this.cafe.equals(cafe);
    }

    public Member getMember(){
        return Member.of(member.getMemberId(), member.getPassword(), member.getAuthType(), member.getPhoneNum());
    }

    public Cafe getCafe(){
        return Cafe.of(cafe.getCafeInfo(), cafe.getBusinessHours());
    }

    public CafeMenu getCafeMenu(){
        return CafeMenu.of(cafeMenu.getMenuName(), cafeMenu.getTemperatureOption(), cafeMenu.getExplain(), cafeMenu.getStock(), cafeMenu.getPrice());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return Objects.equals(member, cart.member) &&
                Objects.equals(cafe, cart.cafe) &&
                Objects.equals(cafeMenu, cart.cafeMenu)
                ;
    }


}

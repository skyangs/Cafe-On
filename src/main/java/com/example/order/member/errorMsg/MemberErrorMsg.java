package com.example.order.member.errorMsg;

import lombok.Getter;

@Getter
public enum MemberErrorMsg {
    AMOUNT_UNDER_ZERO_ERROR_MESSAGE("장바구니에 담을 수 있는 음료 수량은 0개 이상이여야합니다.");

    private final String value;

    MemberErrorMsg(String value){
        this.value = value;
    }

}

package com.example.order.order.errorMsg;

import lombok.Getter;

@Getter
public enum OrderErrorMsg {
    NAME_LENGTH_ERROR_MESSAGE("메뉴 이름은 1자 이상이여야 합니다.");

    private final String value;

    OrderErrorMsg(String value){
        this.value = value;
    }

}

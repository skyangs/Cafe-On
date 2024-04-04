package com.example.order.cafe.errorMsg;

import lombok.Getter;

@Getter
public enum CafeErrorMsg {
    BUSINESS_HOURS_REGEX_ERROR_MESSAGE("영업시간은 HH:mm - HH:mm 혹은 휴무로 입력해야합니다."),
    CAFE_NAME_LENGTH_ERROR_MESSAGE("카페명은 1자 이상이여야 합니다."),
    MENU_NAME_LENGTH_ERROR_MESSAGE("메뉴 이름은 1자 이상이여야 합니다."),
    STOCK_UNDER_ZERO_ERROR_MESSAGE("음료 재고는 0개 이상이여야 합니다."),
    PRICE_UNDER_ZERO_ERROR_MESSAGE("음료 가격은 0원 이상이여야 합니다.");

    private final String value;

    CafeErrorMsg(String value){
        this.value = value;
    }

}

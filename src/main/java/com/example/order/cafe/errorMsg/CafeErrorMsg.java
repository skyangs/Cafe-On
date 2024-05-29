package com.example.order.cafe.errorMsg;

import lombok.Getter;

@Getter
public enum CafeErrorMsg {
    MEMBER_NULL_ERROR_MESSAGE("CE101","회원은 NULL일 수 없습니다."),
    CAFE_INFO_NULL_ERROR_MESSAGE("CE102","카페프로필은 NULL일 수 없습니다."),
    BUSINESS_HOURS_NULL_ERROR_MESSAGE("CE103","운영시간은 NULL일 수 없습니다."),
    ;

    private final String code;
    private final String value;

    CafeErrorMsg(String code, String value){
        this.code = code;
        this.value = value;
    }


}

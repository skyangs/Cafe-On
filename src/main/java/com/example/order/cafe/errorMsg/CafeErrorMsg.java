package com.example.order.cafe.errorMsg;

public enum CafeErrorMsg {
    CAFE_INFO_NULL_ERROR_MESSAGE("CE101","카페프로필은 NULL일 수 없습니다."),
    BUSINESS_HOURS_NULL_ERROR_MESSAGE("CE102", "카페 운영시간은 NULL일 수 없습니다."),
    ;

    private final String code;
    private final String value;

    CafeErrorMsg(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode(){
        return this.value;
    }
    public String getValue(){
        return this.value;
    }

}

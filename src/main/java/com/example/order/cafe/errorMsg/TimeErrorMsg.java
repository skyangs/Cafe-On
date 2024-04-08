package com.example.order.cafe.errorMsg;

public enum TimeErrorMsg {
    TIME_HOUR_RANGE_OUT_ERROR_MESSAGE("T101","Hour는 0-24 사이 숫자만 가능합니다."),
    TIME_MINUTE_RANGE_OUT_ERROR_MESSAGE("T102", "Minute는 0-59 사이 숫자만 가능합니다."),
    ;

    private final String code;
    private final String value;

    TimeErrorMsg(String code, String value){
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

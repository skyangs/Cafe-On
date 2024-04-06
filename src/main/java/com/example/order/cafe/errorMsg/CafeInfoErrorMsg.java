package com.example.order.cafe.errorMsg;

public enum CafeInfoErrorMsg {
    CAFE_NAME_LENGTH_ERROR_MESSAGE("CI101","카페명은 1자 이상이여야 합니다."),
    CAFE_CONTACT_NUM_LENGTH_ERROR_MESSAGE("CI102", "카페 연락처는 9-11자여야 합니다."),
    CAFE_CONTACT_NUM_ONLY_NUMBER_REGEX_ERROR_MESSAGE("CI103","카페 연락처는 숫자로만 이루어져야 합니다."),
    CAFE_CONTACT_NUM_FORMAT_REGEX_ERROR_MESSAGE("CI104","카페 연락처는 000-0000-0000 형식이어야 합니다"),
    ;

    private final String code;
    private final String value;

    CafeInfoErrorMsg(String code, String value){
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

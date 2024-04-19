package com.example.order.member.errorMsg;

public enum CartErrorMsg {
    MEMBER_IS_NULL_ERROR_MESSAGE("CA101","회원 값은 항상 존재해야 합니다."),
    CAFE_IS_NULL_ERROR_MESSAGE("CA102","카페 값은 항상 존재해야 합니다."),
    CAFE_MENU_IS_NULL_ERROR_MESSAGE("CA103","회원 값은 항상 존재해야 합니다."),
    AMOUNT_UNDER_ZERO_ERROR_MESSAGE("CA104","장바구니에 담을 수 있는 음료 수량은 0개 이상이여야합니다.")
    ;

    private final String code;
    private final String value;

    CartErrorMsg(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode(){
        return this.code;
    }

    public String getValue(){
        return this.value;
    }
}

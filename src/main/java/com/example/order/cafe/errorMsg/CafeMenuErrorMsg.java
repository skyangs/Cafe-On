package com.example.order.cafe.errorMsg;

public enum CafeMenuErrorMsg {
    MENU_NAME_LENGTH_ERROR_MESSAGE("CM101","메뉴 이름은 1자 이상이여야 합니다."),
    STOCK_UNDER_ZERO_ERROR_MESSAGE("CM102","음료 재고는 0개 이상이여야 합니다."),
    PRICE_UNDER_ZERO_ERROR_MESSAGE("CM103","음료 가격은 0원 이상이여야 합니다.")

    ;

    private final String code;
    private final String value;

    CafeMenuErrorMsg(String code, String value){
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

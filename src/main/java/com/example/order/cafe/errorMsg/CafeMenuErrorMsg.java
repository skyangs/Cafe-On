package com.example.order.cafe.errorMsg;

public enum CafeMenuErrorMsg {
    MENU_NAME_LENGTH_ERROR_MESSAGE("CM101","메뉴 이름은 1자 이상이여야 합니다."),
    TEMPERATURE_OPTION_NULL_ERROR_MESSAGE("CM102","온도 옵션은 NULL일 수 없습니다."),
    TEMPERATURE_OPTION_EMPTY_ERROR_MESSAGE("CM103","온도 옵션은 반드시 한개 이상 선택하여야합니다."),
    STOCK_UNDER_ZERO_ERROR_MESSAGE("CM104","음료 재고는 0개 이상이여야 합니다."),
    PRICE_UNDER_ZERO_ERROR_MESSAGE("CM105","음료 가격은 0원 이상이여야 합니다.")

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

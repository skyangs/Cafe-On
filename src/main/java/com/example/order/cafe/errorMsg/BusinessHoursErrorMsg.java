package com.example.order.cafe.errorMsg;

public enum BusinessHoursErrorMsg {
    OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG("OD101","운영시간 리스트는 모든 요일의 값을 가져야합니다."),
    ;

    private final String code;
    private final String value;

    BusinessHoursErrorMsg(String code, String value){
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

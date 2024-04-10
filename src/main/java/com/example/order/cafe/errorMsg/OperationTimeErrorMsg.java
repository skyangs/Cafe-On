package com.example.order.cafe.errorMsg;

public enum OperationTimeErrorMsg {
    OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG("OT101","오픈시간은 마감시간보다 빨라야합니다."),
    ;

    private final String code;
    private final String value;

    OperationTimeErrorMsg(String code, String value){
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

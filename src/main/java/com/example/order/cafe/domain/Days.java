package com.example.order.cafe.domain;

public enum Days {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일")
    ;

    private final String value;

    Days(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
package com.example.order.cafe.domain;

public enum TemperatureOption {
    ICE("아이스"),
    HOT("핫")
    ;

    private final String value;

    TemperatureOption(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
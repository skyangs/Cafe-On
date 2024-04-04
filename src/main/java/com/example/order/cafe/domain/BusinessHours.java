package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.CafeErrorMsg;

import java.util.Map;

public class BusinessHours {
    private Map<String, String> hours;

    public BusinessHours(Map<String, String> hours){
        validation(hours);
        this.hours = hours;
    }

    public void validation(Map<String, String> hours){

        String regex = "^([01]\\d|2[0-3]):([0-5]\\d) - ([01]\\d|2[0-3]):([0-5]\\d)$";

        for (Map.Entry<String, String> day : hours.entrySet()){
            String hour = day.getValue();

            boolean check_businessHours_regex = hour.matches(regex);
            boolean closed = hour.equals("휴무");

            if(!check_businessHours_regex && !closed){
                throw new IllegalArgumentException(CafeErrorMsg.BUSINESS_HOURS_REGEX_ERROR_MESSAGE.getValue() + day.getKey());
            }

        }
    }

    public void enrollBusinessHours(Map<String, String> hours){
        this.hours.putAll(hours);
    }

    public void editBusinessHours(Map<String, String> hours){
        this.hours.putAll(hours);
    }

}

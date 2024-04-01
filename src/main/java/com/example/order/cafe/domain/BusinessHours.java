package com.example.order.cafe.domain;

import java.util.Map;

public class BusinessHours {
    private Map<String, String> hours;

    private final String BUSINESS_HOURS_REGEX_ERROR_MESSAGE = "영업시간은 HH:mm - HH:mm 혹은 휴무로 입력해야합니다.";

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
                throw new IllegalArgumentException(BUSINESS_HOURS_REGEX_ERROR_MESSAGE + day.getKey());
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

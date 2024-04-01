package com.example.order.cafe;

import com.example.order.cafe.domain.BusinessHours;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BusinessHoursTest {

    String BUSINESS_HOURS_REGEX_ERROR_MESSAGE = "영업시간은 HH:mm - HH:mm 혹은 휴무로 입력해야합니다.";

    @DisplayName("생성 테스트 : 영업시간 HH:mm - HH:mm의 형태")
    @Test
    public void create_error_business_hours() {
        Map<String, String> 시간리스트 = new HashMap<>();

        String[] 요일 = {"월", "화", "수", "목", "금", "토", "일"};
        String 평소영업시간 = "10:00 - 18:00";
        String 예외영업시간 = "20:00 - 18:00";
        String 휴무 = "휴무";

        for (String day : 요일){
            if(day.equals("월")){
                시간리스트.put(day, 예외영업시간);
            }else if(day.equals("일")){
                시간리스트.put(day, 휴무);
            }else 시간리스트.put(day, 평소영업시간);
        }

        Exception 예외_영업시간 = assertThrows(IllegalArgumentException.class,
                () -> new BusinessHours(시간리스트));

        assertThat(예외_영업시간.getMessage()).isEqualTo(BUSINESS_HOURS_REGEX_ERROR_MESSAGE);

    }
}
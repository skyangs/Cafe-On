package com.example.order.cafe;

import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CafeTest {

    @DisplayName("생성 테스트 : 영업시간 HH:mm - HH:mm의 형태")
    @Test
    public void create_error_business_hours() {

        String 카페명 = "스타벅스";
        String 카페설명 = "저희카페는 강남에 위치해있습니다.";
        String 연락처 = "021111111";
        String 주소 = "서울시 강남구 1010동";

        CafeInfo 카페프로필 = new CafeInfo(카페명, 카페설명, 연락처, 주소);

        Map<String, String> 시간리스트 = new HashMap<>();

        String[] 요일 = {"월", "화", "수", "목", "금", "토", "일"};
        String 평소영업시간 = "10:00 - 18:00";
        String 휴무 = "휴무";

        for (String day : 요일){
            if(day.equals("일")){
                시간리스트.put(day, 휴무);
            }else 시간리스트.put(day, 평소영업시간);
        }

        System.out.println(시간리스트);
        BusinessHours 영업시간 = new BusinessHours(시간리스트);

        Cafe cafe = new Cafe(카페프로필, 영업시간);

        assertThat(cafe.getCafeInfo().getAddress()).isEqualTo("서울시 강남구 1010동");

    }

}

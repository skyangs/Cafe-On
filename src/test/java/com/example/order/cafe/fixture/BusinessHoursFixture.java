package com.example.order.cafe.fixture;

import com.example.order.cafe.domain.*;

import java.util.ArrayList;
import java.util.List;

public class BusinessHoursFixture {

    public static final OperationTime 평일_운영시간 = OperationTime.of(Time.of(9, 0), Time.of(17, 0));
    public static final OperationTime 주말_운영시간 = OperationTime.of(Time.of(0, 0), Time.of(0, 0));

    public static List<OperationTimePerDay> 운영시간_리스트_월화수목금토(){

        OperationTimePerDay 월요일 =  OperationTimePerDay.of(Days.MONDAY, 평일_운영시간);
        OperationTimePerDay 화요일 =  OperationTimePerDay.of(Days.TUESDAY, 평일_운영시간);
        OperationTimePerDay 수요일 =  OperationTimePerDay.of(Days.WEDNESDAY, 평일_운영시간);
        OperationTimePerDay 목요일 =  OperationTimePerDay.of(Days.THURSDAY, 평일_운영시간);
        OperationTimePerDay 금요일 =  OperationTimePerDay.of(Days.FRIDAY, 평일_운영시간);
        OperationTimePerDay 토요일 =  OperationTimePerDay.of(Days.SATURDAY, 주말_운영시간);

        List<OperationTimePerDay> 운영시간_리스트 = new ArrayList<>();

        운영시간_리스트.add(월요일);
        운영시간_리스트.add(화요일);
        운영시간_리스트.add(수요일);
        운영시간_리스트.add(목요일);
        운영시간_리스트.add(금요일);
        운영시간_리스트.add(토요일);

        return 운영시간_리스트;
    }

    public static BusinessHours 운영시간_전체기본생성(){

        List<OperationTimePerDay> 운영시간_리스트 = 운영시간_리스트_월화수목금토();
        OperationTimePerDay 일요일 =  OperationTimePerDay.of(Days.SUNDAY, 주말_운영시간);
        운영시간_리스트.add(일요일);

        return BusinessHours.of(운영시간_리스트);
    }
}

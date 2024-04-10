package com.example.order.cafe;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.errorMsg.BusinessHoursErrorMsg;
import com.example.order.cafe.errorMsg.OperationTimePerDayErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BusinessHoursTest {

    @DisplayName("생성 : 정상")
    @Test
    public void create() {

        OperationTime 평일_운영시간 = new OperationTime(new Time(9, 0), new Time(17, 0));
        OperationTime 주말_운영시간 = new OperationTime(new Time(0, 0), new Time(0, 0));
        OperationTimePerDay 월요일 =  new OperationTimePerDay(Days.MONDAY, 평일_운영시간);
        OperationTimePerDay 화요일 =  new OperationTimePerDay(Days.TUESDAY, 평일_운영시간);
        OperationTimePerDay 수요일 =  new OperationTimePerDay(Days.WEDNESDAY, 평일_운영시간);
        OperationTimePerDay 목요일 =  new OperationTimePerDay(Days.THURSDAY, 평일_운영시간);
        OperationTimePerDay 금요일 =  new OperationTimePerDay(Days.FRIDAY, 평일_운영시간);
        OperationTimePerDay 토요일 =  new OperationTimePerDay(Days.SATURDAY, 주말_운영시간);
        OperationTimePerDay 일요일 =  new OperationTimePerDay(Days.SUNDAY, 주말_운영시간);

        List<OperationTimePerDay> 운영시간_리스트 = new ArrayList<>();

        운영시간_리스트.add(월요일);
        운영시간_리스트.add(화요일);
        운영시간_리스트.add(수요일);
        운영시간_리스트.add(목요일);
        운영시간_리스트.add(금요일);
        운영시간_리스트.add(토요일);
        운영시간_리스트.add(일요일);

        assertThat(new BusinessHours(운영시간_리스트).getTimePerDay(Days.SATURDAY))
                .isEqualTo(주말_운영시간.makeOperationTimeList());

    }

    @DisplayName("생성 예외 : 리스트 길이 - 7")
    @Test
    public void create_error_operationTimePerDay_length() {

        OperationTime 평일_운영시간 = new OperationTime(new Time(9, 0), new Time(17, 0));
        OperationTime 주말_운영시간 = new OperationTime(new Time(0, 0), new Time(0, 0));
        OperationTimePerDay 월요일 =  new OperationTimePerDay(Days.MONDAY, 평일_운영시간);
        OperationTimePerDay 화요일 =  new OperationTimePerDay(Days.TUESDAY, 평일_운영시간);
        OperationTimePerDay 수요일 =  new OperationTimePerDay(Days.WEDNESDAY, 평일_운영시간);
        OperationTimePerDay 목요일 =  new OperationTimePerDay(Days.THURSDAY, 평일_운영시간);
        OperationTimePerDay 금요일 =  new OperationTimePerDay(Days.FRIDAY, 평일_운영시간);
        OperationTimePerDay 토요일 =  new OperationTimePerDay(Days.SATURDAY, 주말_운영시간);
        OperationTimePerDay 일요일 =  new OperationTimePerDay(Days.SUNDAY, 주말_운영시간);

        List<OperationTimePerDay> 운영시간_리스트 = new ArrayList<>();

        운영시간_리스트.add(월요일);
        운영시간_리스트.add(화요일);
        운영시간_리스트.add(수요일);
        운영시간_리스트.add(목요일);
        운영시간_리스트.add(금요일);
        운영시간_리스트.add(토요일);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BusinessHours(운영시간_리스트)
                )
                .withMessage(BusinessHoursErrorMsg.OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG.getValue());

    }

    @DisplayName("생성 예외 : 요일 - 중복 삽입 불가")
    @Test
    public void create_error_duplicate_dayOfWeek() {

        OperationTime 평일_운영시간 = new OperationTime(new Time(9, 0), new Time(17, 0));
        OperationTime 주말_운영시간 = new OperationTime(new Time(0, 0), new Time(0, 0));
        OperationTimePerDay 월요일 =  new OperationTimePerDay(Days.MONDAY, 평일_운영시간);
        OperationTimePerDay 화요일 =  new OperationTimePerDay(Days.TUESDAY, 평일_운영시간);
        OperationTimePerDay 수요일 =  new OperationTimePerDay(Days.WEDNESDAY, 평일_운영시간);
        OperationTimePerDay 목요일 =  new OperationTimePerDay(Days.THURSDAY, 평일_운영시간);
        OperationTimePerDay 금요일 =  new OperationTimePerDay(Days.FRIDAY, 평일_운영시간);
        OperationTimePerDay 토요일 =  new OperationTimePerDay(Days.SATURDAY, 주말_운영시간);
        OperationTimePerDay 일요일 =  new OperationTimePerDay(Days.SUNDAY, 주말_운영시간);

        List<OperationTimePerDay> 운영시간_리스트 = new ArrayList<>();

        운영시간_리스트.add(월요일);
        운영시간_리스트.add(화요일);
        운영시간_리스트.add(수요일);
        운영시간_리스트.add(목요일);
        운영시간_리스트.add(금요일);
        운영시간_리스트.add(토요일);
        운영시간_리스트.add(월요일);

        BusinessHours 운영시간 = new BusinessHours(운영시간_리스트);

        assertThatIllegalArgumentException()
                .isThrownBy(운영시간::isDuplicateDay
                )
                .withMessage(OperationTimePerDayErrorMsg.BUSINESS_HOURS_NOT_DUPLICATE_DAY_ERROR_MESSAGE.getValue());

    }


    @DisplayName("생성 : 운영시간 리스트 수정")
    @Test
    public void create_add_operationTimePerDay_to_list() {

    }

}
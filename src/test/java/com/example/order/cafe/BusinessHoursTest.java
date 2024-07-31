package com.example.order.cafe;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.errorMsg.BusinessHoursErrorMsg;
import com.example.order.cafe.fixture.BusinessHoursFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BusinessHoursTest {

    @DisplayName("생성 : 정상")
    @Test
    public void create() {

        assertThat(BusinessHoursFixture.운영시간_전체기본생성().getTimePerDay(Days.SATURDAY))
                .isEqualTo(BusinessHoursFixture.주말_운영시간.makeOperationTimeList());

    }

    @DisplayName("생성 예외 : 리스트 길이 - 7")
    @Test
    public void createErrorOperationTimePerDayLength() {
        List<OperationTimePerDay> 운영시간_리스트 = BusinessHoursFixture.운영시간_리스트_월화수목금토();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> BusinessHours.of((운영시간_리스트)))
                .withMessage(BusinessHoursErrorMsg.OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG.getValue());

    }

    @DisplayName("생성 예외 : 요일 - 중복 삽입 불가")
    @Test
    public void createErrorDuplicateDayOfWeek() {
        List<OperationTimePerDay> 운영시간_리스트 = BusinessHoursFixture.운영시간_리스트_월화수목금토();

        OperationTimePerDay 중복_월요일 =  OperationTimePerDay.of(Days.MONDAY, BusinessHoursFixture.평일_운영시간);
        운영시간_리스트.add(중복_월요일);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> BusinessHours.of((운영시간_리스트)))
                .withMessage(BusinessHoursErrorMsg.OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG.getValue());

    }


}
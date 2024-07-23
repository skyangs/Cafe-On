package com.example.order.cafe;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.errorMsg.OperationTimePerDayErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperationTimePerDayTest {

    @DisplayName("생성 : 정상")
    @Test
    public void create(){

        int 오픈_시 = 15;
        int 오픈_분 = 30;

        int 마감_시 = 23;
        int 마감_분 = 59;

        Time 오픈_시간 = Time.of(오픈_시, 오픈_분);
        Time 마감_시간 = Time.of(마감_시, 마감_분);

        Days 요일 = Days.WEDNESDAY;
        OperationTime 운영시간 = OperationTime.of(오픈_시간, 마감_시간);
        long 운영시간_id = 1L;
        OperationTimePerDay 하루_운영시간 = OperationTimePerDay.of(요일, 운영시간);

        assertThat(하루_운영시간.getDays()).isEqualTo(요일);
        assertThat(하루_운영시간.getOperationTime()).isEqualTo(운영시간);
    }

    @DisplayName("생성 예외 : 운영시간 null")
    @Test
    public void createMakeOperationTimeListSameOpenClose() {

        Days 월요일 = Days.MONDAY;
        OperationTime 운영시간_널 = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> OperationTimePerDay.of(월요일, 운영시간_널))
                .withMessage(OperationTimePerDayErrorMsg.OPERATION_TIME_NON_NULL_ERROR_MSG.getValue());

    }

}

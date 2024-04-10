package com.example.order.cafe;

import com.example.order.cafe.domain.Days;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.Time;
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

        Time 오픈_시간 = new Time(오픈_시, 오픈_분);
        Time 마감_시간 = new Time(마감_시, 마감_분);

        OperationTime 운영시간 = new OperationTime(오픈_시간, 마감_시간);
        OperationTimePerDay 하루_운영시간 = new OperationTimePerDay(Days.수, 운영시간);

        assertThat(하루_운영시간.getDays()).isEqualTo(Days.수);
        assertThat(하루_운영시간.getOperationTime()).isEqualTo(운영시간);
    }

    @DisplayName("생성 예외 : 운영시간 null")
    @Test
    public void create_makeOperationTimeList_sameOpenClose() {

        Days 월요일 = Days.월;
        OperationTime 운영시간_빈값 = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new OperationTimePerDay(월요일, 운영시간_빈값))
                .withMessage(OperationTimePerDayErrorMsg.OPERATION_TIME_NON_NULL_ERROR_MSG.getValue());

    }

}

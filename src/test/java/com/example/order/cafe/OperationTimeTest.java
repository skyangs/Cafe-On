package com.example.order.cafe;

import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.Time;
import com.example.order.cafe.errorMsg.OperationTimeErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperationTimeTest {

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

        assertThat(운영시간.isOpen(오픈_시간)).isTrue();
        assertThat(운영시간.isClose(마감_시간)).isTrue();
    }

    @DisplayName("생성 예외 : 오픈시간 < 마감시간")
    @ParameterizedTest
    @CsvSource({"23, 0, 0, 0", "15, 59, 15, 0", "12, 0, 12, 0"})
    public void create_error_compare_to_time(int 비정상_오픈_시, int 비정상_오픈_븐, int 비정상_마감_시, int 비정상_마감_분) {

        Time 오픈_시간 = new Time(비정상_오픈_시, 비정상_오픈_븐);
        Time 마감_시간 = new Time(비정상_마감_시, 비정상_마감_분);

        OperationTime 운영시간 = new OperationTime(오픈_시간, 마감_시간);

        assertThatIllegalArgumentException()
                .isThrownBy(운영시간::CheckOpenTimeIsFasterThanCloseTime)
                .withMessage(OperationTimeErrorMsg.OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG.getValue());
    }

    @DisplayName("생성 : 운영시간 형식 - '00:00 - 23:59'")
    @Test
    public void create_minute_format() {

        int 오픈_시 = 00;
        int 오픈_분 = 00;

        int 마감_시 = 23;
        int 마감_분 = 59;

        Time 오픈_시간 = new Time(오픈_시, 오픈_분);
        Time 마감_시간 = new Time(마감_시, 마감_분);

        OperationTime 운영시간 = new OperationTime(오픈_시간, 마감_시간);

        String 운영시간_형식 = 오픈_시간.formatHourAndMinute() + OperationTime.HYPHEN  + 마감_시간.formatHourAndMinute();
        assertThat(운영시간.formatOperationTime()).isEqualTo(운영시간_형식);

    }


}

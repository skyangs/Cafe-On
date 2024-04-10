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

    @DisplayName("생성 : 오픈시간 = 마감시간")
    @ParameterizedTest
    @CsvSource({"12, 0, 12, 0"})
    public void create_makeOperationTimeList_sameOpenClose(int 같은_오픈_시, int 같은_오픈_븐, int 같은_마감_시, int 같은_마감_분) {

        Time 같은_오픈_시간 = new Time(같은_오픈_시, 같은_오픈_븐);
        Time 같은_마감_시간 = new Time(같은_마감_시, 같은_마감_분);

        OperationTime 같은_운영시간 = new OperationTime(같은_오픈_시간, 같은_마감_시간);
        assertThat(같은_운영시간.makeOperationTimeList()).isEqualTo(OperationTime.DAY_OFF);

    }

    @DisplayName("생성 : 오픈시간 > 마감시간")
    @ParameterizedTest
    @CsvSource({"23, 59, 0, 0", "12, 59, 12, 0"})
    public void create_makeOperationTimeList_openAfterClose(int 이후_오픈_시, int 이후_오픈_븐, int 이전_마감_시, int 이전_마감_분) {

        Time 이후_오픈_시간 = new Time(이후_오픈_시, 이후_오픈_븐);
        Time 이전_마감_시간 = new Time(이전_마감_시, 이전_마감_분);

        OperationTime 늦은오픈_빠른마감_운영시간 = new OperationTime(이후_오픈_시간, 이전_마감_시간);

        assertThatIllegalArgumentException()
                .isThrownBy(늦은오픈_빠른마감_운영시간::makeOperationTimeList)
                .withMessage(OperationTimeErrorMsg.OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG.getValue());
    }

    @DisplayName("생성 : 오픈시간 < 마감시간")
    @ParameterizedTest
    @CsvSource({"0, 0, 23, 59", "12, 0, 12, 59"})
    public void create_makeOperationTimeList_openBeforeClose(int 이전_오픈_시, int 이전_오픈_븐, int 이후_마감_시, int 이후_마감_분) {

        Time 이전_오픈_시간 = new Time(이전_오픈_시, 이전_오픈_븐);
        Time 이후_마감_시간 = new Time(이후_마감_시, 이후_마감_분);

        OperationTime 빠른오픈_늦은마감_운영시간 = new OperationTime(이전_오픈_시간, 이후_마감_시간);

        assertThat(빠른오픈_늦은마감_운영시간.makeOperationTimeList()).isEqualTo(빠른오픈_늦은마감_운영시간.formatOperationTime());

    }

    @DisplayName("생성 : 오픈시간 = 마감시간")
    @ParameterizedTest
    @CsvSource({"1, 0, 1, 0"})
    public void create_time_is_same(int 같은시간_오픈_시, int 같은시간_오픈_븐, int 같은시간_마감_시, int 같은시간_마감_분) {

        Time 같은시간_오픈_시간 = new Time(같은시간_오픈_시, 같은시간_오픈_븐);
        Time 같은시간_마감_시간 = new Time(같은시간_마감_시, 같은시간_마감_분);

        OperationTime 다른_운영시간 = new OperationTime(같은시간_오픈_시간, 같은시간_마감_시간);

        assertThat(다른_운영시간.isOpenSameAsClose()).isTrue();
    }

    @DisplayName("생성 : 오픈시간 > 마감시간")
    @ParameterizedTest
    @CsvSource({"23, 59, 0, 0"})
    public void create_open_after_close(int 이후_오픈_시, int 이후_오픈_븐, int 이전_마감_시, int 이전_마감_분) {

        Time 이후_오픈_시간 = new Time(이후_오픈_시, 이후_오픈_븐);
        Time 이전_마감_시간 = new Time(이전_마감_시, 이전_마감_분);

        OperationTime 다른_운영시간 = new OperationTime(이후_오픈_시간, 이전_마감_시간);

        assertThat(다른_운영시간.isOpenAfterClose()).isTrue();
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

        String 운영시간_형식 = 오픈_시간.formatHourAndMinute() + " - "  + 마감_시간.formatHourAndMinute();
        assertThat(운영시간.formatOperationTime()).isEqualTo(운영시간_형식);

    }


}

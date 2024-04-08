package com.example.order.cafe;

import com.example.order.cafe.domain.Time;
import com.example.order.cafe.errorMsg.TimeErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TimeTest {

    @DisplayName("생성 : 정상")
    @Test
    public void create(){

        int 시 = 15;
        int 분 = 30;

        Time time = new Time(시, 분);

        assertThat(time.isHour(시)).isTrue();
    }

    @DisplayName("생성 예외 : Hour 범위 (0-23)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 24})
    public void create_error_hour_range(int 비정상_시_범위) {

        int 분 = 30;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Time(비정상_시_범위, 분);
                })
                .withMessage(TimeErrorMsg.TIME_HOUR_RANGE_OUT_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : Minute 범위 (0-59)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 60})
    public void create_error_minute_range(int 비정상_분_범위){

        int 시 = 15;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Time(시, 비정상_분_범위);
                })
                .withMessage(TimeErrorMsg.TIME_MINUTE_RANGE_OUT_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : Minute 범위 (0-59)")
    @ParameterizedTest
    @CsvSource({"-1, -1", "-1, 60", "24, -1", "24, 60"})
    public void create_error_hour_minute_range(int 비정상_시_범위, int 비정상_분_범위){

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Time(비정상_시_범위, 비정상_분_범위);
                })
                .withMessage(TimeErrorMsg.TIME_HOUR_RANGE_OUT_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 : Hour 형식 - 10 이하의 수")
    @Test
    public void create_hour_format() {

        int 한자리수_시 = 9;
        int 분 = 30;

        String 변경된_시_형식 = "0" + 한자리수_시;

        Time time = new Time(한자리수_시, 분);

        assertThat(time.formatHour(한자리수_시)).isEqualTo(변경된_시_형식);

    }

    @DisplayName("생성 : Minute 형식 - 10 이하의 수")
    @Test
    public void create_minute_format() {

        int 시 = 10;
        int 한자리수_분 = 9;

        String 변경된_분_형식 = "0" + 한자리수_분;

        Time time = new Time(시, 한자리수_분);

        assertThat(time.formatMinute(한자리수_분)).isEqualTo(변경된_분_형식);

    }

    @DisplayName("생성 : 시간 형식 리턴")
    @Test
    public void create_hour_minute_format() {

        int 한자리수_시 = 9;
        int 한자리수_분 = 9;

        String 변경된_시_형식 = "0" + 한자리수_시;
        String 변경된_분_형식 = "0" + 한자리수_분;
        String 변경된_시간_형식 = 변경된_시_형식 + ":" + 변경된_분_형식;

        Time time = new Time(한자리수_시, 한자리수_분);

        assertThat(time.formatHourAndMinute(한자리수_시, 한자리수_분)).isEqualTo(변경된_시간_형식);

    }

}

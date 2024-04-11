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

        Time 시간 = Time.of(시, 분);

        assertThat(시간.isHour(시)).isTrue();
    }

    @DisplayName("생성 예외 : Hour 범위 (0-23)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 24})
    public void create_error_hour_range(int 비정상_시_범위) {

        int 분 = 30;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Time.of(비정상_시_범위, 분);
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
                    Time.of(시, 비정상_분_범위);
                })
                .withMessage(TimeErrorMsg.TIME_MINUTE_RANGE_OUT_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : Minute 범위 (0-59)")
    @ParameterizedTest
    @CsvSource({"-1, -1", "-1, 60", "24, -1", "24, 60"})
    public void create_error_hour_minute_range(int 비정상_시_범위, int 비정상_분_범위){

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Time.of(비정상_시_범위, 비정상_분_범위);
                })
                .withMessage(TimeErrorMsg.TIME_HOUR_RANGE_OUT_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 : Hour 형식 - 10 이하의 수")
    @Test
    public void create_hour_format() {

        int 한자리수_시 = 9;
        int 분 = 30;

        Time 시간 = Time.of(한자리수_시, 분);

        assertThat(시간.formatHour(한자리수_시)).isEqualTo(시간.formatMinute(한자리수_시));

    }

    @DisplayName("생성 : Minute 형식 - 10 이하의 수")
    @Test
    public void create_minute_format() {

        int 시 = 10;
        int 한자리수_분 = 9;

        Time 시간 = Time.of(시, 한자리수_분);

        assertThat(시간.formatMinute(한자리수_분)).isEqualTo(시간.formatMinute(한자리수_분));

    }

    @DisplayName("생성 : 시간 형식 리턴")
    @Test
    public void create_hour_minute_format() {

        int 한자리수_시 = 9;
        int 한자리수_분 = 9;

        Time 시간 = Time.of(한자리수_시, 한자리수_분);

        String 변경된_시_형식 = 시간.formatHour(한자리수_시);
        String 변경된_분_형식 = 시간.formatMinute(한자리수_분);
        String 변경된_시간_형식 = 변경된_시_형식 + ":" + 변경된_분_형식;

        assertThat(시간.formatHourAndMinute()).isEqualTo(변경된_시간_형식);

    }

    @DisplayName("생성 : 시간 비교")
    @ParameterizedTest
    @CsvSource({"0, 30, 23, 0,", "23, 59, 1, 0","12, 0, 12, 0"})
    public void create_compare_to_time(int 오픈_시, int 오픈_분, int 마감_시, int 마감_분 ) {

        Time 오픈_시간 = Time.of(오픈_시, 오픈_분);
        Time 마감_시간 = Time.of(마감_시, 마감_분);

        if(오픈_시 < 마감_시){
            assertThat(오픈_시간.compareTime(마감_시간)).isEqualTo(Time.IS_BEFORE_TIME);
        }

        if (오픈_시 > 마감_시) {
            assertThat(오픈_시간.compareTime(마감_시간)).isEqualTo(Time.IS_AFTER_TIME);
        }

        if (오픈_시 == 마감_시) {
            assertThat(오픈_시간.compareTime(마감_시간)).isEqualTo(Time.IS_SAME_TIME);
        }

    }

    @DisplayName("생성 : 시간 - 분으로 계산")
    @Test
    public void create_calculate_time() {

        int 시 = 12;
        int 분 = 30;

        Time 시간 = Time.of(시, 분);
        int 분_계산 = 시 * 60 + 분;

        assertThat(시간.calculateTotalMinute(시, 분)).isEqualTo(분_계산);

    }

}

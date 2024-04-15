package com.example.order.cafe;

import com.example.order.cafe.domain.CafeMenu;
import com.example.order.cafe.domain.TemperatureOption;
import com.example.order.cafe.errorMsg.CafeMenuErrorMsg;
import com.example.order.cafe.fixture.CafeMenuFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CafeMenuTest {

    @DisplayName("생성 : 정상")
    @Test
    public void create(){

        CafeMenu 카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();

        assertThat(카페메뉴.isMenuName(CafeMenuFixture.메뉴명)).isTrue();
    }

    @DisplayName("생성 예외 : 메뉴명 - 최소 1자 이상")
    @Test
    public void create_error_menu_name_length() {

        String 빈_메뉴명 = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(빈_메뉴명,
                                CafeMenuFixture.온도옵션리스트,
                                CafeMenuFixture.설명,
                                CafeMenuFixture.재고,
                                CafeMenuFixture.가격))
                .withMessage(CafeMenuErrorMsg.MENU_NAME_LENGTH_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 온도옵션 리스트 - null 불가")
    @Test
    public void create_error_temperature_option_null(){

        List<TemperatureOption> 널_온도옵션리스트 = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(CafeMenuFixture.메뉴명,
                                널_온도옵션리스트,
                                CafeMenuFixture.설명,
                                CafeMenuFixture.재고,
                                CafeMenuFixture.가격))
                .withMessage(CafeMenuErrorMsg.TEMPERATURE_OPTION_NULL_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 온도옵션 리스트 - 1개 이상 포함")
    @Test
    public void create_error_temperature_option_empty(){

        List<TemperatureOption> 빈_온도옵션리스트 = List.of();


        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(CafeMenuFixture.메뉴명,
                                빈_온도옵션리스트,
                                CafeMenuFixture.설명,
                                CafeMenuFixture.재고,
                                CafeMenuFixture.가격))
                .withMessage(CafeMenuErrorMsg.TEMPERATURE_OPTION_EMPTY_ERROR_MESSAGE.getValue());

    }


    @DisplayName("생성 예외 : 재고 - 0개 이상")
    @Test
    public void create_error_stock(){

        int 음수_재고 = -1;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(CafeMenuFixture.메뉴명,
                                CafeMenuFixture.온도옵션리스트,
                                CafeMenuFixture.설명, 음수_재고,
                                CafeMenuFixture.가격))
                .withMessage(CafeMenuErrorMsg.STOCK_UNDER_ZERO_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 가격 - 0원 이상")
    @Test
    public void create_error_price(){

        int 음수_가격 = -1;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(CafeMenuFixture.메뉴명,
                                CafeMenuFixture.온도옵션리스트,
                                CafeMenuFixture.설명,
                                CafeMenuFixture.재고,
                                음수_가격))
                .withMessage(CafeMenuErrorMsg.PRICE_UNDER_ZERO_ERROR_MESSAGE.getValue());

    }


    @DisplayName("생성 : 같은 객체 비교 - 설명, 재고만 다를 때")
    @Test
    public void create_error_equal() {

        String 다른_설명 = "산미가 있고 시원합니다.";
        int 다른_재고 = 0;

        CafeMenu 첫번째_카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();
        CafeMenu 두번째_카페메뉴 = CafeMenu.of(CafeMenuFixture.메뉴명,
                CafeMenuFixture.온도옵션리스트,
                다른_설명,
                다른_재고,
                CafeMenuFixture.가격);

        assertEquals(첫번째_카페메뉴, 두번째_카페메뉴);

    }

}

package com.example.order.cafe;

import com.example.order.cafe.domain.CafeMenu;
import com.example.order.cafe.domain.TemperatureOption;
import com.example.order.cafe.errorMsg.CafeMenuErrorMsg;
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

        String 메뉴명 = "아메리카노";
        List<TemperatureOption> 온도옵션리스트 = List.of(TemperatureOption.HOT, TemperatureOption.ICE);
        String 설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        int 재고 = 1000;
        int 가격 = 4500;

        CafeMenu 카페메뉴 = CafeMenu.of(메뉴명, 온도옵션리스트, 설명, 재고, 가격);

        assertThat(카페메뉴.isMenuName(메뉴명)).isTrue();
    }

    @DisplayName("생성 예외 : 메뉴명 - 최소 1자 이상")
    @Test
    public void create_error_menu_name_length() {

        String 빈_메뉴명 = "";
        List<TemperatureOption> 온도옵션리스트 = List.of(TemperatureOption.HOT, TemperatureOption.ICE);
        String 설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        int 재고 = 1000;
        int 가격 = 4500;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                    CafeMenu.of(빈_메뉴명, 온도옵션리스트, 설명, 재고, 가격))
                .withMessage(CafeMenuErrorMsg.MENU_NAME_LENGTH_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 온도옵션 리스트 - null 불가")
    @Test
    public void create_error_temperature_option_null(){

        String 메뉴명 = "아메리카노";
        List<TemperatureOption> 널_온도옵션리스트 = null;
        String 설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        int 재고 = 5;
        int 가격 = 4500;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(메뉴명, 널_온도옵션리스트, 설명, 재고, 가격))
                .withMessage(CafeMenuErrorMsg.TEMPERATURE_OPTION_NULL_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 온도옵션 리스트 - 1개 이상 포함")
    @Test
    public void create_error_temperature_option_empty(){

        String 메뉴명 = "아메리카노";
        List<TemperatureOption> 빈_온도옵션리스트 = List.of();
        String 설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        int 재고 = 5;
        int 가격 = 4500;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(메뉴명, 빈_온도옵션리스트, 설명, 재고, 가격))
                .withMessage(CafeMenuErrorMsg.TEMPERATURE_OPTION_EMPTY_ERROR_MESSAGE.getValue());

    }


    @DisplayName("생성 예외 : 재고 - 0개 이상")
    @Test
    public void create_error_stock(){

        String 메뉴명 = "아메리카노";
        List<TemperatureOption> 온도옵션리스트 = List.of(TemperatureOption.HOT, TemperatureOption.ICE);
        String 설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        int 음수_재고 = -1;
        int 가격 = 4500;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(메뉴명, 온도옵션리스트, 설명, 음수_재고, 가격))
                .withMessage(CafeMenuErrorMsg.STOCK_UNDER_ZERO_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 가격 - 0원 이상")
    @Test
    public void create_error_price(){

        String 메뉴명 = "아메리카노";
        List<TemperatureOption> 온도옵션리스트 = List.of(TemperatureOption.HOT, TemperatureOption.ICE);
        String 설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        int 재고 = 5;
        int 음수_가격 = -1;

        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        CafeMenu.of(메뉴명, 온도옵션리스트, 설명, 재고, 음수_가격))
                .withMessage(CafeMenuErrorMsg.PRICE_UNDER_ZERO_ERROR_MESSAGE.getValue());

    }


    @DisplayName("생성 : 같은 객체 비교 - 설명, 재고만 다를 때")
    @Test
    public void create_error_equal() {

        String 메뉴명 = "아메리카노";
        List<TemperatureOption> 온도옵션리스트 = List.of(TemperatureOption.HOT, TemperatureOption.ICE);
        int 가격 = 4500;

        String 첫번째_설명 = "에스프레소를 부드럽게 즐길 수 있습니다.";
        String 두번째_설명 = "산미가 있고 시원합니다.";
        int 첫번째_재고 = 5;
        int 두번째_재고 = 0;


        CafeMenu 첫번째_카페메뉴 = CafeMenu.of(메뉴명, 온도옵션리스트, 첫번째_설명, 첫번째_재고, 가격);
        CafeMenu 두번째_카페메뉴 = CafeMenu.of(메뉴명, 온도옵션리스트, 두번째_설명, 두번째_재고, 가격);

        assertEquals(첫번째_카페메뉴, 두번째_카페메뉴);

    }

}

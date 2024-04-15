package com.example.order.member;

import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.domain.CafeMenu;
import com.example.order.cafe.fixture.BusinessHoursFixture;
import com.example.order.cafe.fixture.CafeInfoFixture;
import com.example.order.cafe.fixture.CafeMenuFixture;
import com.example.order.member.domain.Cart;
import com.example.order.member.domain.Member;
import com.example.order.member.errorMsg.CartErrorMsg;
import com.example.order.member.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @DisplayName("생성 : 정상 테스트")
    @Test
    public void create(){

        Member 멤버 = MemberFixture.회원_기본생성();
        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);
        CafeMenu 카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();
        int 수량 = 2;

        Cart 장바구니 = Cart.of(멤버, 카페, 카페메뉴, 수량);

        assertEquals(장바구니.getMember(), 멤버);
        assertEquals(장바구니.getCafe(), 카페);
        assertEquals(장바구니.getCafeMenu(), 카페메뉴);

    }

    @DisplayName("생성 예외 : 회원 null")
    @Test
    public void create_error_member(){

        Member 멤버_널 = null;
        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);
        CafeMenu 카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();
        int 수량 = 2;

        assertThatNullPointerException()
                .isThrownBy(() -> {
                    Cart.of(멤버_널, 카페, 카페메뉴, 수량);
                })
                .withMessage(CartErrorMsg.MEMBER_IS_NULL_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 카페 null")
    @Test
    public void create_error_cafe(){

        Member 멤버 = MemberFixture.회원_기본생성();
        Cafe 카페_널 = null;
        CafeMenu 카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();
        int 수량 = 2;

        assertThatNullPointerException()
                .isThrownBy(() -> {
                    Cart.of(멤버, 카페_널, 카페메뉴, 수량);
                })
                .withMessage(CartErrorMsg.CAFE_IS_NULL_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 카페메뉴 null")
    @Test
    public void create_error_cafeMenu(){

        Member 멤버 = MemberFixture.회원_기본생성();
        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);
        CafeMenu 카페메뉴_널 = null;
        int 수량 = 2;

        assertThatNullPointerException()
                .isThrownBy(() -> {
                    Cart.of(멤버, 카페, 카페메뉴_널, 수량);
                })
                .withMessage(CartErrorMsg.CAFE_MENU_IS_NULL_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 수량 0개 이상")
    @Test
    public void create_error_amount(){

        Member 멤버 = MemberFixture.회원_기본생성();
        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);
        CafeMenu 카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();
        int 음수_수량 = -1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Cart.of(멤버, 카페, 카페메뉴, 음수_수량);
                })
                .withMessage(CartErrorMsg.AMOUNT_UNDER_ZERO_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 : 장바구니 내 카페 비교")
    @Test
    public void compare_cafe(){

        Member 멤버 = MemberFixture.회원_기본생성();
        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);

        CafeMenu 첫번쩨_카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();

        String 두번째_메뉴명 = "카페라떼";
        String 두번째_설명 = "고소합니다.";
        CafeMenu 두번째_카페메뉴 = CafeMenu.of(두번째_메뉴명,
                CafeMenuFixture.온도옵션리스트,
                두번째_설명,
                CafeMenuFixture.재고,
                CafeMenuFixture.가격);

        int 수량 = 2;

        Cart 첫번째_장바구니 = Cart.of(멤버, 카페, 첫번쩨_카페메뉴, 수량);
        Cart 두번째_장바구니 = Cart.of(멤버, 카페, 두번째_카페메뉴, 수량);

        assertThat(첫번째_장바구니.compareCafe(두번째_장바구니.getCafe())).isTrue();

    }

    @DisplayName("생성 : 객체 비교 - 회원, 카페, 카페메뉴 같을 때")
    @Test
    public void create_equals(){

        Member 멤버 = MemberFixture.회원_기본생성();
        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);
        CafeMenu 카페메뉴 = CafeMenuFixture.카페메뉴_기본생성();

        int 첫번째_수량 = 2;
        int 두번째_수량 = 4;

        Cart 첫번째_장바구니 = Cart.of(멤버, 카페, 카페메뉴, 첫번째_수량);
        Cart 두번째_장바구니 = Cart.of(멤버, 카페, 카페메뉴, 두번째_수량);
        assertEquals(첫번째_장바구니, 두번째_장바구니);

    }

}

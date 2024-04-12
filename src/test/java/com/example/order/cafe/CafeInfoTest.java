package com.example.order.cafe;

import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.errorMsg.CafeInfoErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CafeInfoTest {

    @DisplayName("생성 : 정상")
    @Test
    public void create(){

        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 연락처  = "02-111-1111";
        String 주소=  "서울시 강남구 1010동";

        CafeInfo 카페프로필 = CafeInfo.of(카페명, 설명, 연락처, 주소);

        assertThat(카페프로필.isMyAddress(주소)).isTrue();
    }

    @DisplayName("생성 예외 : 카페명 - 1글자 이상")
    @Test
    public void create_error_name_length() {

        String 빈_카페명 = "";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 연락처  = "02-111-1111";
        String 주소=  "서울시 강남구 1010동";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    CafeInfo.of(빈_카페명, 설명, 연락처, 주소);
                })
                .withMessage(CafeInfoErrorMsg.CAFE_NAME_LENGTH_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 카페 연락처 자릿수 - 9-11자리")
    @ParameterizedTest
    @ValueSource(strings = {"02-111-111","031-11111-1111","031-11-111","0312-1111-1111"})
    public void create_error_phoneNum_length(String 비정상_연락처_자릿수){

        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 주소=  "서울시 강남구 1010동";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    CafeInfo.of(카페명, 설명, 비정상_연락처_자릿수, 주소);
                })
                .withMessage(CafeInfoErrorMsg.CAFE_CONTACT_NUM_LENGTH_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 카페 연락처 유효문자 - 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"연락처-글자가-한글일때", "aaa-aaaa-aaaa", "연락처-aaa-123"})
    public void create_error_phoneNum_only_number_regex(String 연락처_유효문자){

        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 주소=  "서울시 강남구 1010동";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    CafeInfo.of(카페명, 설명, 연락처_유효문자, 주소);
                })
                .withMessage(CafeInfoErrorMsg.CAFE_CONTACT_NUM_ONLY_NUMBER_REGEX_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 카페 연락처 형식 - (2,3)-(3,4)-(4)")
    @ParameterizedTest
    @ValueSource(strings = {"01000000000", "0100000-0000", "010-00000000","0109-000-0000","010-00-0000","010-000-00000"})
    public void create_error_phoneNum_format(String 연락처_형식){

        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 주소=  "서울시 강남구 1010동";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    CafeInfo.of(카페명, 설명, 연락처_형식, 주소);
                })
                .withMessage(CafeInfoErrorMsg.CAFE_CONTACT_NUM_FORMAT_REGEX_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 카페 연락처 자릿수 + 유효문자 + 형식 - (2,3)-(3,4)-(4) 9-11자리 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바사아", "가나다라마바사아자차카타","가나다-라마바사12345","가나다-라마바사-12345"})
    public void create_error_phoneNum(String 예외연락처){

        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 주소=  "서울시 강남구 1010동";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    CafeInfo.of(카페명, 설명, 예외연락처, 주소);
                })
                .withMessage(CafeInfoErrorMsg.CAFE_CONTACT_NUM_LENGTH_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 : 같은 객체 비교 - 설명 내용만 다를 때")
    @Test
    public void create_error_equal() {

        String 빈_설명 = "";
        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 연락처  = "02-111-1111";
        String 주소=  "서울시 강남구 1010동";

        CafeInfo 카페프로필_설명있음 = CafeInfo.of(카페명, 설명, 연락처, 주소);
        CafeInfo 카페프로필_설명없음 = CafeInfo.of(카페명, 빈_설명, 연락처, 주소);

        assertEquals(카페프로필_설명있음, 카페프로필_설명없음);

    }

    @DisplayName("생성 예외 : 다른 객체 비교 - 다를 때")
    @Test
    public void create_error_equal_1() {

        String 카페명 = "id123";
        String 설명 = "저희카페는 강남에 위치해있습니다.";
        String 연락처  = "02-111-1111";
        String 주소=  "서울시 강남구 1010동";

        String 다른_카페명 = "cafeName";
        String 다른_연락처 = "02-999-9999";
        String 다른_주소 = "부산시";

        CafeInfo 카페프로필_기본 = CafeInfo.of(카페명, 설명, 연락처, 주소);
        CafeInfo 카페프로필_다른카페명 = CafeInfo.of(다른_카페명, 설명, 연락처, 주소);
        CafeInfo 카페프로필_다른연락처 = CafeInfo.of(카페명, 설명, 다른_연락처, 주소);
        CafeInfo 카페프로필_다른주소 = CafeInfo.of(카페명, 설명, 연락처, 다른_주소);

        assertNotEquals(카페프로필_기본, 카페프로필_다른카페명);
        assertNotEquals(카페프로필_기본, 카페프로필_다른연락처);
        assertNotEquals(카페프로필_기본, 카페프로필_다른주소);

    }
}

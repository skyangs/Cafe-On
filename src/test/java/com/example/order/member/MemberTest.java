package com.example.order.member;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;
import com.example.order.member.errorMsg.MemberErrorMsg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MemberTest {

    @DisplayName("생성 : 정상 테스트")
    @Test
    public void create(){

        String 아이디 = "id123";
        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "010-1111-1111";
        
        Member member = new Member(아이디, 비밀번호, 권한, 연락처);

        assertThat(member.getMemberId()).isEqualTo(아이디);
    }


    @DisplayName("생성 예외 : 아이디 자릿수 - 4-10자리 사이")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "abcdefghijk"})
    public void create_error_id_length(String 아이디_자릿수){

        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "010-1111-1111";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                        new Member(아이디_자릿수, 비밀번호, 권한, 연락처);
                })
                .withMessage(MemberErrorMsg.MEMBER_ID_LENGTH_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 아이디 유효문자 - 영문+숫자")
    @ParameterizedTest
    @ValueSource(strings = {"abcd", "1234","한글아이디","한글12","ad한글"})
    public void create_error_id_regex(String 아이디_유효문자){

        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "010-1111-1111";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디_유효문자, 비밀번호, 권한, 연락처);
                })
                .withMessage(MemberErrorMsg.MEMBER_ID_REGEX_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 아이디 자릿수 + 유효문자 - 영문+숫자 4-10자리 사이")
    @ParameterizedTest
    @ValueSource(strings = {"한글1", "a한글","한글123456789","abcdefghi한글"})
    public void create_error_id(String 아이디_자릿수_유효문자){

        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "010-1111-1111";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디_자릿수_유효문자, 비밀번호, 권한, 연락처);
                })
                .withMessage(MemberErrorMsg.MEMBER_ID_LENGTH_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 비밀번호 자릿수 - 8-15자 사이")
    @ParameterizedTest
    @ValueSource(strings = {"passwor", "passwordpassword"})
    public void create_error_password(String 비밀번호_자릿수){

        String 아이디 = "id123";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "010-1111-1111";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디, 비밀번호_자릿수, 권한, 연락처);
                })
                .withMessage(MemberErrorMsg.MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 휴대폰번호 자릿수 - 11자리")
    @ParameterizedTest
    @ValueSource(strings = {"010-1111-111", "010-1111-11111"})
    public void create_error_phoneNum_length(String 연락처_자릿수){

        String 아이디 = "id123";
        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디, 비밀번호, 권한, 연락처_자릿수);
                })
                .withMessage(MemberErrorMsg.MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 휴대폰번호 유효문자 - 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"연락처-열한자리-한글일때", "aaa-aaaa-aaaa"})     
    public void create_error_phoneNum_only_number_regex(String 연락처_유효문자){

        String 아이디 = "id123";
        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디, 비밀번호, 권한, 연락처_유효문자);
                })
                .withMessage(MemberErrorMsg.MEMBER_PHONE_NUM_ONLY_NUMBER_REGEX_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 휴대폰번호 형식 - 000-0000-0000")
    @ParameterizedTest
    @ValueSource(strings = {"01000000000", "0100000-0000", "010-00000000"})
    public void create_error_phoneNum_format(String 연락처_형식){

        String 아이디 = "id123";
        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디, 비밀번호, 권한, 연락처_형식);
                })
                .withMessage(MemberErrorMsg.MEMBER_PHONE_NUM_FORMAT_REGEX_ERROR_MESSAGE.getValue());

    }

    @DisplayName("생성 예외 : 휴대폰번호 자릿수 + 유효문자 + 형식 - 000-0000-0000 11자리 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바사아자차", "가나다라마바사아자차카타"})
    public void create_error_phoneNum(String 연락처){

        String 아이디 = "id123";
        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Member(아이디, 비밀번호, 권한, 연락처);
                })
                .withMessage(MemberErrorMsg.MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE.getValue());

    }

}

package com.example.order.member;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberTest {
    String MEMBER_ID_LENGTH_ERROR_MESSAGE = "아이디는 4-10자여야 합니다.";
    String MEMBER_ID_REGEX_ERROR_MESSAGE = "아이디는 영문과 숫자로 이루어져야 합니다.";
    String MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE = "비밀번호는 8-15자여야 합니다.";
    String MEMBER_PHONE_NUM_REGEX_ERROR_MESSAGE = "휴대폰번호는 숫자로만 이루어져야 합니다.";
    String MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE = "휴대폰번호는 11자리여야 합니다.";

    @DisplayName("생성 테스트 : 아이디 자릿수 영문+숫자 4-10자리 사이")
    @Test
    public void create_error_id(){

        String 아이디_3자리 = "abc";
        String 아이디_11자리 = "abcdefghijk";

        String 아이디_영문 = "abcd";
        String 아이디_숫자 = "1234";
        String 아이디_한글 = "한글아이디";

        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "01011111111";

        Exception 예외_아이디_3자리 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디_3자리, 비밀번호, 권한, 연락처));

        assertThat(예외_아이디_3자리.getMessage()).isEqualTo(MEMBER_ID_LENGTH_ERROR_MESSAGE);

        Exception 예외_아이디_11자리 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디_11자리, 비밀번호, 권한, 연락처));

        assertThat(예외_아이디_11자리.getMessage()).isEqualTo(MEMBER_ID_LENGTH_ERROR_MESSAGE);

        Exception 예외_아이디_영문 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디_영문, 비밀번호, 권한, 연락처));

        assertThat(예외_아이디_영문.getMessage()).isEqualTo(MEMBER_ID_REGEX_ERROR_MESSAGE);

        Exception 예외_아이디_숫자 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디_숫자, 비밀번호, 권한, 연락처));

        assertThat(예외_아이디_숫자.getMessage()).isEqualTo(MEMBER_ID_REGEX_ERROR_MESSAGE);

        Exception 예외_아이디_한글 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디_한글, 비밀번호, 권한, 연락처));

        assertThat(예외_아이디_한글.getMessage()).isEqualTo(MEMBER_ID_REGEX_ERROR_MESSAGE);
    }

    @DisplayName("생성 테스트 : 비밀번호는 8-15자 사이")
    @Test
    public void create_error_password(){

        String 비밀번호_7자리 = "passwor";
        String 비밀번호_16자리 = "passwordpassword";

        String 아이디 = "abc12";
        AuthType 권한  = AuthType.USER;
        String 연락처 =  "01011111111";

        Exception 예외_아이디_3자리 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디, 비밀번호_7자리, 권한, 연락처));

        assertThat(예외_아이디_3자리.getMessage()).isEqualTo(MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE);

        Exception 예외_아이디_11자리 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디, 비밀번호_16자리, 권한, 연락처));

        assertThat(예외_아이디_11자리.getMessage()).isEqualTo(MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE);

    }

    @DisplayName("생성 테스트 : 휴대폰번호 11자리 숫자")
    @Test
    public void create_error_phoneNum(){

        String 아이디 = "abc12";
        String 비밀번호 = "password";
        AuthType 권한  = AuthType.USER;
        String 연락처_10자리 =  "0101111111";
        String 연락처_한글 = "연락처열한자리한글일때";

        Exception 예외_휴대폰번호_10자리 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디, 비밀번호, 권한, 연락처_10자리));

        assertThat(예외_휴대폰번호_10자리.getMessage()).isEqualTo(MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE);

        Exception 예외_휴대폰번호_한글 = assertThrows(IllegalArgumentException.class,
                () -> new Member(아이디, 비밀번호, 권한, 연락처_한글));

        assertThat(예외_휴대폰번호_한글.getMessage()).isEqualTo(MEMBER_PHONE_NUM_REGEX_ERROR_MESSAGE);

    }
}

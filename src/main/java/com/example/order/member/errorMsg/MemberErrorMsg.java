package com.example.order.member.errorMsg;

public enum MemberErrorMsg {
    MEMBER_ID_LENGTH_ERROR_MESSAGE("M101","아이디는 4-10자여야 합니다."),
    MEMBER_ID_REGEX_ERROR_MESSAGE("M102","아이디는 영문과 숫자로 이루어져야 합니다."),
    MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE("M201","비밀번호는 8-15자여야 합니다."),
    MEMBER_PASSWORD_NULL_ERROR_MESSAGE("M202","비밀번호는 NULL일 수 없습니다."),
    MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE("M301","휴대폰번호는 11자리여야 합니다."),
    MEMBER_PHONE_NUM_ONLY_NUMBER_REGEX_ERROR_MESSAGE("M302","휴대폰번호는 숫자로만 이루어져야 합니다."),
    MEMBER_PHONE_NUM_FORMAT_REGEX_ERROR_MESSAGE("M303","휴대전화 번호는 000-0000-0000 형식이어야 합니다"),

    ;

    private final String code;
    private final String value;

    MemberErrorMsg(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}

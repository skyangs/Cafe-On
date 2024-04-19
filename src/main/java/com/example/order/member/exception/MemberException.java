package com.example.order.member.exception;

public enum MemberException {

    ALREADY_EXIST_MEMBER_ID_EXCEPTION("이미 존재하는 ID입니다."),
    ;

    private final String value;

    MemberException(String value) {
        this.value = value;
    }
}

package com.example.order.member.errorCode;

import lombok.Getter;

@Getter
public enum MemberErrorCode {

    ALREADY_EXIST_MEMBER_ID_EXCEPTION("이미 존재하는 ID입니다."),
    ;

    private final String value;

    MemberErrorCode(String value) {
        this.value = value;
    }
}

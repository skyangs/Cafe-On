package com.example.order.member.fixture;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;

public class MemberFixture {

    public static final String 아이디 = "id123";
    public static final String 비밀번호 = "password";
    public static final String 이름 = "스프링";
    public static final AuthType 권한 = AuthType.USER;
    public static final String 연락처 = "010-1111-1111";

    public static Member 회원_기본생성(){
        return Member.of(아이디, 비밀번호, 이름, 권한, 연락처);
    }

}

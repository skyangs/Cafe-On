package com.example.order.member.service.dto.response;

import com.example.order.member.domain.AuthType;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final String memberId;
    private final String password;
    private final String name;
    private final AuthType authType;
    private final String phoneNum;

    public MemberResponse(String memberId, String password, String name, AuthType authType, String phoneNum){
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.authType = authType;
        this.phoneNum = phoneNum;
    }

}

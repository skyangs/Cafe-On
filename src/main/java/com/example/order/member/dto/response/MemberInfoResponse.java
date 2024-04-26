package com.example.order.member.dto.response;

import com.example.order.member.domain.AuthType;
import lombok.Getter;

@Getter
public class MemberInfoResponse {

    private final String memberId;
    private final String password;
    private final String name;
    private final AuthType authType;
    private final String phoneNum;

    public MemberInfoResponse(String memberId, String password, String name, AuthType authType, String phoneNum){
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.authType = authType;
        this.phoneNum = phoneNum;
    }

}

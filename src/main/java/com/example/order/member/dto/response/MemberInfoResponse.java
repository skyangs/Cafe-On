package com.example.order.member.dto.response;

import com.example.order.member.domain.AuthType;

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

    public String getMemberId(){
        return memberId;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public AuthType getAuthType(){
        return authType;
    }

    public String getPhoneNum(){
        return phoneNum;
    }
}

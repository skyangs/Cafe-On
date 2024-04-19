package com.example.order.member.dto.request;

import com.example.order.member.domain.AuthType;
import lombok.Data;

public class UpdateMemberInfoRequest {

    private final String password;
    private final AuthType authType;
    private final String phoneNum;

    public UpdateMemberInfoRequest(String password, AuthType authType, String phoneNum){
        this.password = password;
        this.authType = authType;
        this.phoneNum = phoneNum;
    }

}

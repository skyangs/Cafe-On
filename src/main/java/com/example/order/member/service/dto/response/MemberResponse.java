package com.example.order.member.service.dto.response;

import com.example.order.member.domain.AuthType;

public record MemberResponse(
        String memberId,
        String password,
        String name,
        AuthType authType,
        String phoneNum
){}

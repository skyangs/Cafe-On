package com.example.order.member.mapper;

import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberInfoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberInfoResponse toMemberInfoResponse(Member member);
    List<MemberInfoResponse> toMemberInfoResponseList(List<Member> member);
}
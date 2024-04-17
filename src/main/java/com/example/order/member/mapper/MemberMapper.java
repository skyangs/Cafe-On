package com.example.order.member.mapper;

import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberInfoResponse toMemberInfoResponse(Member member);
    List<MemberInfoResponse> toMemberInfoResponseList(List<Member> member);
}
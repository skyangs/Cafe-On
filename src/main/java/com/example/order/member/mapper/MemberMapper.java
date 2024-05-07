package com.example.order.member.mapper;

import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberResponse toMemberResponse(Member member);
    List<MemberResponse> toMemberResponseList(List<Member> member);
}
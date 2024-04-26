package com.example.order.member.mapper;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberInfoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-26T16:55:42+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberInfoResponse toMemberInfoResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        String memberId = null;
        String password = null;
        String name = null;
        AuthType authType = null;
        String phoneNum = null;

        memberId = member.getMemberId();
        password = member.getPassword();
        name = member.getName();
        authType = member.getAuthType();
        phoneNum = member.getPhoneNum();

        MemberInfoResponse memberInfoResponse = new MemberInfoResponse( memberId, password, name, authType, phoneNum );

        return memberInfoResponse;
    }

    @Override
    public List<MemberInfoResponse> toMemberInfoResponseList(List<Member> member) {
        if ( member == null ) {
            return null;
        }

        List<MemberInfoResponse> list = new ArrayList<MemberInfoResponse>( member.size() );
        for ( Member member1 : member ) {
            list.add( toMemberInfoResponse( member1 ) );
        }

        return list;
    }
}

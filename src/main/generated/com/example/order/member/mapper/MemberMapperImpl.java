package com.example.order.member.mapper;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T19:40:51+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberResponse toMemberResponse(Member member) {
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

        MemberResponse memberResponse = new MemberResponse( memberId, password, name, authType, phoneNum );

        return memberResponse;
    }

    @Override
    public List<MemberResponse> toMemberResponseList(List<Member> member) {
        if ( member == null ) {
            return null;
        }

        List<MemberResponse> list = new ArrayList<MemberResponse>( member.size() );
        for ( Member member1 : member ) {
            list.add( toMemberResponse( member1 ) );
        }

        return list;
    }
}

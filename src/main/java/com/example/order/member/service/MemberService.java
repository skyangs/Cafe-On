package com.example.order.member.service;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberInfoResponse;
import com.example.order.member.exception.MemberException;
import com.example.order.member.mapper.MemberMapper;
import com.example.order.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberInfoResponse getMemberInfo(long id){

        Member member = check_existMember(id);

        return memberMapper.INSTANCE.toMemberInfoResponse(member);
    }

    public List<MemberInfoResponse> getMemberInfoList(){
        List<Member> memberList = memberRepository.findAll();

        return memberMapper.INSTANCE.toMemberInfoResponseList(memberList);
    }

    @Transactional
    public Member signUp(String memberId, String password, String name, AuthType authType,String phoneNum){

        memberRepository.findByMemberId(memberId)
                .ifPresent(member -> {
                    throw new RuntimeException(MemberException.ALREADY_EXIST_MEMBER_ID_EXCEPTION.getValue());
                });

        Member newMember = Member.of(memberId, password, name, authType, phoneNum);
        return memberRepository.save(newMember);
    }

    @Transactional
    public void updateMemberInfo(long id, String password, AuthType authType, String phoneNum){

        Member member = check_existMember(id);

        Member updateMember = Member.of(
                id,
                member.getMemberId(),
                password,
                member.getName(),
                authType,
                phoneNum);

        memberRepository.save(updateMember);
    }

    @Transactional
    public void deleteMember(long id){

        Member member = check_existMember(id);

        memberRepository.delete(member);

    }

    public Member check_existMember(long id){

        return memberRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}

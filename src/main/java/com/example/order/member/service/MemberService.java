package com.example.order.member.service;

import com.example.order.member.domain.Member;
import com.example.order.member.service.dto.request.SignUpRequest;
import com.example.order.member.service.dto.request.UpdateMemberRequest;
import com.example.order.member.service.dto.response.MemberResponse;
import com.example.order.member.errorCode.MemberErrorCode;
import com.example.order.member.mapper.MemberMapper;
import com.example.order.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberResponse getMember(long id){

        Member member = checkExistMember(id);

        return memberMapper.toMemberResponse(member);
    }

    public List<MemberResponse> getMemberList(){
        List<Member> memberList = memberRepository.findAll();

        return memberMapper.toMemberResponseList(memberList);
    }

    @Transactional
    public Member signUp(SignUpRequest request){
        Optional<Member> member = memberRepository.findByMemberId(request.memberId());

        if(member.isPresent()){
            throw new RuntimeException(MemberErrorCode.ALREADY_EXIST_MEMBER_ID_EXCEPTION.getValue());
        }

        Member newMember = Member.of(request.memberId(), request.password(), request.name(), request.authType(), request.phoneNum(), request.grade());
        return memberRepository.save(newMember);
    }

    @Transactional
    public void updateMember(long id, UpdateMemberRequest request){

        Member member = checkExistMember(id);
        member.updateMember(request.password(), request.authType(), request.phoneNum());
    }

    @Transactional
    public void deleteMember(long id){
        memberRepository.delete(checkExistMember(id));
    }

    private Member checkExistMember(long id){

        return memberRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

}

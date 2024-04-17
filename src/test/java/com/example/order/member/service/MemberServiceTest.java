package com.example.order.member.service;

import com.example.order.member.domain.Member;
import com.example.order.member.dto.response.MemberInfoResponse;
import com.example.order.member.fixture.MemberFixture;
import com.example.order.member.mapper.MemberMapper;
import com.example.order.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("MemberService 테스트")
public class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Test
    @DisplayName("정상 : 회원가입 테스트")
    public void signUp(){

        given(memberRepository.findByMemberId(MemberFixture.아이디)).willReturn(Optional.empty());

        memberService.signUp(MemberFixture.아이디, MemberFixture.비밀번호, MemberFixture.이름, MemberFixture.권한, MemberFixture.연락처);

        then(memberRepository).should(times(0)).findByMemberId(String.valueOf(any(Member.class)));
        then(memberRepository).should().save(any(Member.class));
    }

    @Test
    @DisplayName("예외 : 존재하는 아이디 회원가입 테스트")
    public void signUp_error_alreadyExist_id(){

        Member 존재하는_회원 = MemberFixture.회원_기본생성();
        given(memberRepository.findByMemberId(MemberFixture.아이디)).willReturn(Optional.of(존재하는_회원));

        assertThatRuntimeException()
                .isThrownBy(() -> memberService.signUp(MemberFixture.아이디, MemberFixture.비밀번호, MemberFixture.이름, MemberFixture.권한, MemberFixture.연락처))
                        .withMessage("이미 존재하는 ID입니다.");

        then(memberRepository).should(times(1)).findByMemberId(존재하는_회원.getMemberId());
        then(memberRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    @DisplayName("정상 : 회원 정보 조회")
    public void getMemberInfoTest(){

        long 회원_id = 1L;
        Member 회원 = MemberFixture.회원_기본생성();
        given(memberRepository.findById(회원_id)).willReturn(Optional.of(회원));

        MemberInfoResponse memberInfoResponse = memberService.getMemberInfo(회원_id);

        assertThat(memberInfoResponse.getName()).isEqualTo(회원.getName());
        then(memberRepository).should(times(1)).findById(회원_id);
    }

    @Test
    @DisplayName("예외 : 회원 정보 없을 때")
    public void signUp_error_getMemberInfo(){

        long 회원_id = 1L;
        given(memberRepository.findById(회원_id)).willReturn(Optional.empty());

        assertThatRuntimeException()
                .isThrownBy(() -> memberService.getMemberInfo(회원_id))
                .isInstanceOf(NoSuchElementException.class);

    }

}

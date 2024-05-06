package com.example.order.member.controller;

import com.example.order.member.domain.AuthType;
import com.example.order.member.domain.Member;
import com.example.order.member.dto.request.SignUpRequest;
import com.example.order.member.dto.request.UpdateMemberInfoRequest;
import com.example.order.member.dto.response.MemberInfoResponse;
import com.example.order.member.fixture.MemberFixture;
import com.example.order.member.repository.MemberRepository;
import com.example.order.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @Test
    @DisplayName("정상 : 회원가입")
    void signupTest() throws Exception {

        SignUpRequest signUpRequest = MemberFixture.회원가입_REQEUST_DTO();

        mockMvc.perform(post("/members/signup")
                        .content(objectMapper.writeValueAsString(signUpRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());

    }

    @Test
    @DisplayName("예외 : 아이디 중복 시 회원가입")
    void signupTest_error() throws Exception {
    }

    @Test
    @DisplayName("정상 : 회원 정보 조회")
    void getMemberInfoTest() throws Exception {

        when(memberService.getMemberInfo(1L)).thenReturn(MemberFixture.회원가입_RESPONSE_DTO());

        mockMvc.perform(get("/members/{id}",1L))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.memberId").value(MemberFixture.아이디));

    }

    @Test
    @DisplayName("정상 : 전체 회원 정보 조회")
    void getMemberInfoListTest() throws Exception {

        String 두번째_아이디 ="123id";
        String 두번째_비밀번호 = "password";
        String 두번째_이름 = "회원정보";
        AuthType 두번째_권한 = AuthType.CAFE_OWNER;
        String 두번째_연락처 = "22222222222";

        List<MemberInfoResponse> RESPONSE_회원_리스트 = List.of(MemberFixture.회원가입_RESPONSE_DTO(),
                new MemberInfoResponse(두번째_아이디, 두번째_비밀번호, 두번째_이름, 두번째_권한, 두번째_연락처));

        when(memberService.getMemberInfoList()).thenReturn(RESPONSE_회원_리스트);

        mockMvc.perform(get("/members/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$[0].memberId").value(MemberFixture.아이디))
                .andExpect(jsonPath("$[1].memberId").value(두번째_아이디));
    }

    @Test
    @DisplayName("정상 : 회원 정보 수정")
    void updateMemberInfoTest() throws Exception {

        String 변경_비밀번호 = "pass1234";
        AuthType 변경_권한 = AuthType.CAFE_OWNER;
        String 변경_연락처 = "33333333333";

        Member 회원 = MemberFixture.회원_기본생성();
        when(memberService.check_existMember(1L)).thenReturn(회원);

        UpdateMemberInfoRequest updateMemberInfoRequest = new UpdateMemberInfoRequest(변경_비밀번호, 변경_권한, 변경_연락처);

        mockMvc.perform(patch("/members/{id}", 1L)
                        .content(objectMapper.writeValueAsString(updateMemberInfoRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
//                .andExpect(jsonPath("$[0].phoneNum").value(변경_연락처));
    }

    @Test
    @DisplayName("정상 : 회원 정보 삭제")
    void deleteMemberTest() throws Exception {

        doNothing().when(memberService).deleteMember(anyLong());

        mockMvc.perform(delete("/members/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}

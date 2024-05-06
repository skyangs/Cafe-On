package com.example.order.member.controller;

import com.example.order.member.domain.Member;
import com.example.order.member.dto.request.SignUpRequest;
import com.example.order.member.dto.request.UpdateMemberInfoRequest;
import com.example.order.member.dto.response.MemberInfoResponse;
import com.example.order.member.repository.MemberRepository;
import com.example.order.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/members")
@Tag( name = "Member", description = "회원 API")
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    @Operation(summary = "회원 정보 조회", description = "특정 회원의 정보를 조회한다.")
    public ResponseEntity<MemberInfoResponse> getMemberInfo(@PathVariable("id") long id){

        return ResponseEntity.ok()
                .body(memberService.getMemberInfo(id));
    }

    @GetMapping("/all")
    @Operation(summary = "회원 정보 전체 조회", description = "모든 회원의 정보를 조회한다.")
    public ResponseEntity<List<MemberInfoResponse>> getMemberInfoList(){

        return ResponseEntity.ok()
                .body(memberService.getMemberInfoList());
    }

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "새로운 회원의 정보를 등록한다.")
    public ResponseEntity<Object> signup(@Validated @RequestBody SignUpRequest signUpRequest){
        Member member = memberService.signUp(signUpRequest.getMemberId(),
                signUpRequest.getPassword(),
                signUpRequest.getName(),
                signUpRequest.getAuthType(),
                signUpRequest.getPhoneNum());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/singup")
                .buildAndExpand(member.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "회원 정보 수정", description = "특정 회원의 정보를 수정한다.")
    public ResponseEntity<Object> updateMemberInfo(@PathVariable("id") long id, @Validated @RequestBody UpdateMemberInfoRequest updateMemberInfoRequest){

        memberService.updateMemberInfo(id,
                updateMemberInfoRequest.getPassword(),
                updateMemberInfoRequest.getAuthType(),
                updateMemberInfoRequest.getPhoneNum());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "회원 탈퇴", description = "회원의 정보를 삭제한다.")
    public ResponseEntity<Object> deleteMember(@PathVariable("id") long id){

        memberService.deleteMember(id);

        return ResponseEntity.noContent().build();
    }



}

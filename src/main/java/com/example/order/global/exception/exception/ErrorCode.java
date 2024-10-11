package com.example.order.global.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  //400 BAD REQUEST 잘못된 요청

  //404 NOT FOUND 잘못된 리소스
  MEMBER_NOT_FOUND(400, "존재하지 않는 회원 정보입니다."),

  //409 CONFLICT 중복된 리소스
  ALREADY_EXIST_MEMBER_ID(409, "이미 존재하는 ID입니다."),

  //500 INTERNAL SERVER ERROR
  INTERNAL_SERVER_ERROR(500, "서버 에러입니다.");

  private final int status;
  private final String message;
}

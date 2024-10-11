package com.example.order.global.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

  private int status;
  private String errorMsg;

  public ErrorResponse(ErrorCode errorCode) {
    this.status = errorCode.getStatus();
    this.errorMsg = errorCode.getMessage();
  }
}
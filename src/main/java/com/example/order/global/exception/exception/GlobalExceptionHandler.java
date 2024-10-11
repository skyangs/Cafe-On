package com.example.order.global.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleException(CustomException e) {
    return new ResponseEntity<>(new ErrorResponse(e.getErrorCode()),
        HttpStatus.valueOf(e.getErrorCode().getStatus()));
  }
}
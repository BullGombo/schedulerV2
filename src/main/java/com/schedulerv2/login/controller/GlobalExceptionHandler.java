package com.schedulerv2.login.controller;

import com.schedulerv2.login.dto.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    @ExceptionHandler(LoginException.class)
    public ErrorResponse handleLoginException(LoginException ex) {
        return new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage()
        );
    }

//    public static class ErrorResponse {
//        public int status;
//        public String message;
//
//        public ErrorResponse(int status, String message) {
//            this.status = status;
//            this.message = message;
//        }
//    }
}

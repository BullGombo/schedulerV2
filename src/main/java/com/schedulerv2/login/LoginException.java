package com.schedulerv2.login;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice // 전역 예외처리
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}

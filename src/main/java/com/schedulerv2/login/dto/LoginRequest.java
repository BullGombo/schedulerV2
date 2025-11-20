package com.schedulerv2.login.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    // ========== Lv 4. 로그인(인증) - 필수
    // 이메일과 비밀번호를 활용해 로그인 기능을 구현
    // 회원가입, 로그인 요청은 인증 처리에서 제외
    private String email;
    private String password;
}

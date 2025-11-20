package com.schedulerv2.login.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    // ========== Lv 4. 로그인(인증) - 필수
    // 이메일과 비밀번호를 활용해 로그인 기능을 구현
    private final Long Id;
    private final String username;
    private final String email;

    public LoginResponse(Long id, String username, String email) {
        this.Id = id;
        this.username = username;
        this.email = email;
    }
}

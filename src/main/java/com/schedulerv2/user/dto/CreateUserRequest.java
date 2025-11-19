package com.schedulerv2.user.dto;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    // 유저 생성 요청시 필요한 필드 : 유저명, 이메일
    private String username;
    private String email;
    // ========== Lv 3. 회원가입 - 필수 - 유저에 `비밀번호` 필드를 추가
    private String password;
}

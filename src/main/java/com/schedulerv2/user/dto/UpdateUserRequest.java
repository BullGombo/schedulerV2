package com.schedulerv2.user.dto;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
    // 유저 수정 요청시 필요한 필드 : 유저명, 이메일
    private String username;
    private String email;
}

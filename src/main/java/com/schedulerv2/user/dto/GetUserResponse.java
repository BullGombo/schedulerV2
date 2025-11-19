package com.schedulerv2.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetUserResponse {
    // 유저 조회 응답시 필요한 필드 : id, 유저명, 이메일, 생성일, 수정일
    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetUserResponse(Long id, String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

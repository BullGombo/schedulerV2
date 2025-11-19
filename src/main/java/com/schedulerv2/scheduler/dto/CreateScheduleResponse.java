package com.schedulerv2.scheduler.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    // 일정 생성 응답시 필요한 필드 : id, 작성자, 제목, 내용, 생성일, 수정일
    private final Long id;
    //private final String writer;
    private final Long userId;

    private final String title;
    private final String content;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CreateScheduleResponse(Long id, Long userId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        //this.writer = writer;
        this.userId = userId;

        this.title = title;
        this.content = content;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

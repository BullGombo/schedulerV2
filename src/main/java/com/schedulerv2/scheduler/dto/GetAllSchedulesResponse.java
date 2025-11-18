package com.schedulerv2.scheduler.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetAllSchedulesResponse {
    // 일정 전체 조회 응답시 필요한 필드 : id, 작성자, 제목, 생성일, 수정일
    private final Long id;
    private final String writer;
    private final String title;
    //private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetAllSchedulesResponse(Long id, String writer, String title, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        //this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

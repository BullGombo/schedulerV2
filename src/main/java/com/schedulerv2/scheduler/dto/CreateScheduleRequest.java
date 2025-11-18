package com.schedulerv2.scheduler.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    // 일정 생성 요청시 필요한 필드 : 작성자, 제목, 내용
    private String writer;
    private String title;
    private String content;

}

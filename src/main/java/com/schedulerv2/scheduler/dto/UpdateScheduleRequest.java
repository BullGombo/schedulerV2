package com.schedulerv2.scheduler.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    // 일정 수정 요청시 필요한 필드 : 제목, 내용
    private String title;
    private String content;

}

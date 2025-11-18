package com.schedulerv2.scheduler.controller;

import com.schedulerv2.scheduler.dto.*;
import com.schedulerv2.scheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    // ############################################## 속성 필드 ##############################################
    // 하위 Layer 참조
    private final ScheduleService scheduleService;



    // ############################################## 메서드 ##############################################
    // ---------------------------------------- 일정 생성 - POST ----------------------------------------
    @PostMapping("/scheduler")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createS(request));
    }

    // ---------------------------------------- 일정 단건 조회 - GET ----------------------------------------
    @GetMapping("/scheduler/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getS(scheduleId));
    }

    // ---------------------------------------- 일정 다건 조회 - GET ----------------------------------------
    @GetMapping("/scheduler")
    public ResponseEntity<List<GetAllSchedulesResponse>> getAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAllS());
    }

    // ---------------------------------------- 일정 수정 - PUT ----------------------------------------
    @PutMapping("/schedule/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateS(scheduleId, request));
    }

    // ---------------------------------------- 일정 삭제 - DELETE ----------------------------------------
    @DeleteMapping("/scheduler/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteS(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

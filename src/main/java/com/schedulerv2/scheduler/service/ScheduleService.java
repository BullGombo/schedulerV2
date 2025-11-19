package com.schedulerv2.scheduler.service;

import com.schedulerv2.scheduler.dto.*;
import com.schedulerv2.scheduler.entity.SchedulerEntity;
import com.schedulerv2.scheduler.repository.SchedulerRepository;
import com.schedulerv2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    // ############################################## 속성 필드 ##############################################
    // 하위 Layer 참조
    private final SchedulerRepository schedulerRepository;

    // 외래 Joined-연관 Repository 참조
    private final UserRepository userRepository;


    // ############################################## 메서드 ##############################################
    // ---------------------------------------- 저장 - POST ----------------------------------------
    @Transactional
    public CreateScheduleResponse createS(Long userId, CreateScheduleRequest request) {

    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public GetScheduleResponse getS(Long scheduleId) {

    }

    // ---------------------------------------- 다건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public List<GetAllSchedulesResponse> getAllS(Long userId) {

    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @Transactional
    public UpdateScheduleResponse updateS(Long scheduleId, UpdateScheduleRequest request) {

    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @Transactional
    public void deleteS(Long scheduleId) {

    }

}

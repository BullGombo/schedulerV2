package com.schedulerv2.user.service;

import com.schedulerv2.scheduler.entity.SchedulerEntity;
import com.schedulerv2.scheduler.repository.SchedulerRepository;
import com.schedulerv2.user.dto.*;
import com.schedulerv2.user.entity.UserEntity;
import com.schedulerv2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    // ############################################## 속성 필드 ##############################################
    // 하위 Layer 참조
    private final UserRepository userRepository;

    // 연관 Repository 참조
    //private final SchedulerRepository schedulerRepository;


    // ############################################## 메서드 ##############################################

    // ---------------------------------------- 생성 - POST ----------------------------------------
    @Transactional
    public CreateUserResponse createU(Long scheduleId, CreateUserRequest request) {


    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public GetUserResponse getU(Long userId) {
    }

    // ---------------------------------------- 다건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public List<GetUserResponse> getAllU(Long scheduleId) {
    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @Transactional
    public UpdateUserResponse updateU(Long userId, UpdateUserRequest request) {
    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @Transactional
    public void deleteU(Long userId) {
    }
}

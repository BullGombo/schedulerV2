package com.schedulerv2.scheduler.service;

import com.schedulerv2.scheduler.dto.*;
import com.schedulerv2.scheduler.entity.SchedulerEntity;
import com.schedulerv2.scheduler.repository.SchedulerRepository;
import com.schedulerv2.user.entity.UserEntity;
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
        // userId를 기반으로 실제 Repository에서 찾아 Entity에 넣기 + 예외처리
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("##### user id : " + userId + " 를 찾을 수 없습니다. #####")
        );

        // 요청 내용을 담은 dto를 기반으로 Entity생성
        SchedulerEntity schedulerEntity = new SchedulerEntity(userEntity, request.getTitle(), request.getContent());

        // 실제 Repository에 생성
        SchedulerEntity savedSchedulerEntity = schedulerRepository.save(schedulerEntity);

        // 응답dto 반환
        return new CreateScheduleResponse(
                savedSchedulerEntity.getId(),
                savedSchedulerEntity.getUser().getId(),

                savedSchedulerEntity.getTitle(),
                savedSchedulerEntity.getContent(),

                savedSchedulerEntity.getCreatedAt(),
                savedSchedulerEntity.getUpdatedAt()
        );
    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public GetScheduleResponse getS(Long scheduleId) {
        // Id를 기반으로 일정 탐색 후 예외처리
        SchedulerEntity schedulerEntity = schedulerRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("##### schedule id : " + scheduleId + " 를 찾을 수 없습니다. #####")
        );

        // 응답dto 반환
        return new GetScheduleResponse(
                schedulerEntity.getId(),
                schedulerEntity.getUser().getId(),

                schedulerEntity.getTitle(),
                schedulerEntity.getContent(),

                schedulerEntity.getCreatedAt(),
                schedulerEntity.getUpdatedAt()
        );
    }

    // ---------------------------------------- 다건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public List<GetAllSchedulesResponse> getAllS(Long userId) {
        // Id를 기반으로 유저 탐색 후 예외처리
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("##### user id : " + userId + " 를 찾을 수 없습니다. #####")
        );

        // userId를 기반으로 일정 탐색 후 리스트에 넣기
        List<SchedulerEntity> schedulerEntities = schedulerRepository.findByUser(userEntity); // 일정Repository에 메서드 구현

        // stream으로 탐색한 user의 모든 일정을 응답 dto리스트로 반환
        return schedulerEntities.stream()
                .map(schedulerEntity -> new GetAllSchedulesResponse(
                        schedulerEntity.getId(),
                        schedulerEntity.getUser().getId(),

                        schedulerEntity.getTitle(),

                        schedulerEntity.getCreatedAt(),
                        schedulerEntity.getUpdatedAt()
                ))
                .toList();
    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @Transactional
    public UpdateScheduleResponse updateS(Long scheduleId, UpdateScheduleRequest request) {
        // id로 Repository에서 탐색 + 예외처리
        SchedulerEntity schedulerEntity = schedulerRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("##### schedule id : " + scheduleId + " 를 찾을 수 없습니다. #####")
        );

        // 요청내용으로 실제 테이블 업데이트
        schedulerEntity.update(request.getTitle(), request.getContent());

        // 응답dto 반환
        return new UpdateScheduleResponse(
                schedulerEntity.getId(),
                schedulerEntity.getUser().getId(),

                schedulerEntity.getTitle(),
                schedulerEntity.getContent(),

                schedulerEntity.getCreatedAt(),
                schedulerEntity.getUpdatedAt()
        );
    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @Transactional
    public void deleteS(Long scheduleId) {
        // id기준 존재여부 확인 후 예외처리
        boolean existence = schedulerRepository.existsById(scheduleId);
        if (!existence) {
            throw new IllegalStateException("##### schedule id : " + scheduleId + " 를 찾을 수 없습니다. #####");
        }

        // Repository에서 일정 삭제
        schedulerRepository.deleteById(scheduleId);

    }

}

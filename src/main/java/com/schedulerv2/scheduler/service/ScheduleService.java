package com.schedulerv2.scheduler.service;

import com.schedulerv2.scheduler.dto.*;
import com.schedulerv2.scheduler.entity.SchedulerEntity;
import com.schedulerv2.scheduler.repository.SchedulerRepository;
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



    // ############################################## 메서드 ##############################################
    // ---------------------------------------- 저장 - POST ----------------------------------------
    @Transactional
    public CreateScheduleResponse createS(CreateScheduleRequest request) {
        // Entity에 요청dto 넣기
        SchedulerEntity scheduler = new SchedulerEntity(request.getWriter(), request.getTitle(), request.getContent());

        // 요청 내용을 채운 Entity테이블의 데이터로 실제 Repository에 저장 + 응답dto 반환에 쓸 변수 할당
        SchedulerEntity savedSchedule = schedulerRepository.save(scheduler);

        // 응답dto 반환
        return new CreateScheduleResponse(
                savedSchedule.getId(),

                savedSchedule.getWriter(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),

                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt()
        );
        
    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public GetScheduleResponse getS(Long scheduleId) {
        // schedulerId를 기반으로 실제 Repository에서 찾아 Entity에 넣기 + 예외처리
        SchedulerEntity searchedSchedule = schedulerRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("##### Scheduler id : " + scheduleId + " 를 찾을 수 없습니다. #####")
        );

        // 응답dto 반환
        return new GetScheduleResponse(
                searchedSchedule.getId(),

                searchedSchedule.getWriter(),
                searchedSchedule.getTitle(),
                searchedSchedule.getContent(),

                searchedSchedule.getCreatedAt(),
                searchedSchedule.getUpdatedAt()
        );
    }

    // ---------------------------------------- 다건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public List<GetAllSchedulesResponse> getAllS() {
        // 스트림으로 간소화한 버전
        // Repository 전체 조회 -> Entity타입 List를 순회하며 Entity타입의 데이터를 dto타입으로 변환 -> 스트림을 순회 - 리스트에 담아서 반환
        return schedulerRepository.findAll()
                .stream()
                .map(scheduler -> new GetAllSchedulesResponse(
                        scheduler.getId(),
                        scheduler.getWriter(),
                        scheduler.getTitle(),
                        scheduler.getCreatedAt(),
                        scheduler.getUpdatedAt()
                ))
                .toList();
    }
//    @Transactional(readOnly = true)
//    public List<GetAllSchedulesResponse> getAllS() {
//        // Repository 전체 조회 후 SchedulerEntity타입 List에 넣기
//        List<SchedulerEntity> searchedAllSchedules = schedulerRepository.findAll();
//
//        // 응답dto 타입의 List 선언
//        List<GetAllSchedulesResponse> allScheduleDtos = new ArrayList<>();
//
//        // 전체 조회한 List를 순회, 각각의 Entity타입 데이터를 dto로 변환하여 응답객체 리스트에 담기
//        for (SchedulerEntity scheduler : searchedAllSchedules) {
//            GetAllSchedulesResponse scheduleDto = new GetAllSchedulesResponse(
//                    scheduler.getId(),
//
//                    scheduler.getWriter(),
//                    scheduler.getTitle(),
//
//                    scheduler.getCreatedAt(),
//                    scheduler.getUpdatedAt()
//            );
//            allScheduleDtos.add(scheduleDto);
//        }
//        return allScheduleDtos;
//    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @Transactional
    public UpdateScheduleResponse updateS(Long scheduleId, UpdateScheduleRequest request) {
        // schedulerId를 기반으로 실제 Repository에서 찾아 Entity에 넣기 + 예외처리
        SchedulerEntity searchedSchedule = schedulerRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("##### Scheduler id : " + scheduleId + " 를 찾을 수 없습니다. #####")
        );

        // 수정
        searchedSchedule.update(request.getTitle(), request.getContent());

        // 응답dto 반환
        return new UpdateScheduleResponse(
                searchedSchedule.getId(),

                searchedSchedule.getWriter(),
                searchedSchedule.getTitle(),
                searchedSchedule.getContent(),

                searchedSchedule.getCreatedAt(),
                searchedSchedule.getUpdatedAt()
        );
    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @Transactional
    public void deleteS(Long scheduleId) {
        boolean existence = schedulerRepository.existsById(scheduleId);
        if (! existence) {
            throw new IllegalStateException("##### Scheduler id : " + scheduleId + " 를 찾을 수 없습니다. #####");
        }
        schedulerRepository.deleteById(scheduleId);
    }

}

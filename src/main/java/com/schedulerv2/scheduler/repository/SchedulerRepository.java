package com.schedulerv2.scheduler.repository;

import com.schedulerv2.scheduler.entity.SchedulerEntity;
import com.schedulerv2.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<SchedulerEntity, Long> {
    // 유저 엔티티로 해당 유저의 일정 전체 조회
    // Spring Data JPA 메서드 네이밍 기반 자동쿼리 생성
    List<SchedulerEntity> findByUser(UserEntity userEntity);
}

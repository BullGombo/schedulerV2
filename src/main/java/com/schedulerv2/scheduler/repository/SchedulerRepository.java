package com.schedulerv2.scheduler.repository;

import com.schedulerv2.scheduler.entity.SchedulerEntity;
import com.schedulerv2.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<SchedulerEntity, Long> {
    List<SchedulerEntity> findByUser(UserEntity userEntity);
}

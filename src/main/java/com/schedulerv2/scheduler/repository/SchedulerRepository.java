package com.schedulerv2.scheduler.repository;

import com.schedulerv2.scheduler.entity.SchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<SchedulerEntity, Long> {
}

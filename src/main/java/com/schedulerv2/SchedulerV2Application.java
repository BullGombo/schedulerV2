package com.schedulerv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Lv1 요구사항 - 작성일, 수정일 -> JPA Auditing
@EnableJpaAuditing
//@Configuration
@SpringBootApplication
public class SchedulerV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerV2Application.class, args);
    }

}

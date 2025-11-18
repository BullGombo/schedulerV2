package com.schedulerv2.scheduler.entity;

import com.schedulerv2.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedulerV2")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchedulerEntity extends BaseEntity {

    // ######################################## 테이블 속성 ########################################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Lv 1. 일정 CRUD - 필수
    // 작성 유저명, 할일 제목, 할일 내용 필드를 가짐
    // 작성일, 수정일 필드는 JPA Auditing을 활용 -> extends BaseEntity
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String title;
    private String content;

    // ######################################## 생성자 ########################################
    // id는 자동으로 할당되므로 제외
    public SchedulerEntity(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    // ######################################## 메서드 ########################################
    // 일정 수정은 본인만 가능하다는 논리 - 작성자명은 수정 불가
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}

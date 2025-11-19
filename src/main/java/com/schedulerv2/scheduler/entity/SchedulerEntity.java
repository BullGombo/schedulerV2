package com.schedulerv2.scheduler.entity;

import com.schedulerv2.BaseEntity;
import com.schedulerv2.user.entity.UserEntity;
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
    //@Column(nullable = false)
    //private String writer;

    // Lv 2. 유저 CRUD - 필수
    // - 연관관계 구현 - 일정은 이제 `작성 유저명` 필드 대신 `유저 고유 식별자` 필드를 가짐
    // 일정이 있어야 그 속의 유저가 존재할 수 있기때문에, optional은 false
    @ManyToOne(fetch = FetchType.LAZY, optional = false)    // optional은 JPA에서 null 혀용 여부
    @JoinColumn(name = "user_id", nullable = false)         // nullable은 DB에서 null 혀용 여부
    private UserEntity user;

    @Column(nullable = false)
    private String title;

    private String content;

    // ######################################## 생성자 ########################################
    // 일정의 id는 자동으로 할당되므로 제외
    public SchedulerEntity(UserEntity user, String title, String content) {
        // this.writer = writer;
        this.user = user;
        this.title = title;
        this.content = content;
    }

    // ######################################## 메서드 ########################################
    // 일정 수정은 본인만 가능하다는 논리 - 유저명은 수정 불가
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}

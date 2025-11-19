package com.schedulerv2.user.entity;

import com.schedulerv2.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

    // ######################################## 테이블 속성 ########################################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ========== Lv 2. 유저 CRUD - 필수
    // 유저명, 이메일 필드를 가짐
    // 작성일, 수정일 필드는 JPA Auditing을 활용 -> extends BaseEntity
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)   // 이메일 형식 지정 알아보기
    private String email;

    // ========== Lv 3. 회원가입 - 필수
    // 유저에 비밀번호 필드를 추가
    @Column(nullable = false)
    private String password;


    // ######################################## 생성자 ########################################
    // id는 자동으로 할당되므로 제외
    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // ######################################## 메서드 ########################################
    // 일정 수정은 본인만 가능하다는 논리 - 작성자명은 수정 불가
    public void update(String username, String email) {
        this.username = username;
        this.email = email;
    }

}

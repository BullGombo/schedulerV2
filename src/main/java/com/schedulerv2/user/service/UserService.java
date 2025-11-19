package com.schedulerv2.user.service;

import com.schedulerv2.user.dto.*;
import com.schedulerv2.user.entity.UserEntity;
import com.schedulerv2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    // ############################################## 속성 필드 ##############################################
    // 하위 Layer 참조
    private final UserRepository userRepository;



    // ############################################## 메서드 ##############################################

    // ---------------------------------------- 생성 - POST ----------------------------------------
    @Transactional
    public CreateUserResponse createU(CreateUserRequest request) {
        // Entity에 요청dto 넣기
        UserEntity userEntity = new UserEntity(request.getUsername(), request.getEmail(), request.getPassword());

        // 요청 내용을 채운 Entity테이블의 데이터로 실제 Repository에 저장 + 응답dto 반환에 쓸 변수 할당
        UserEntity savedUser = userRepository.save(userEntity);

        // 응답dto 반환
        return new CreateUserResponse(
                savedUser.getId(),

                savedUser.getUsername(),
                savedUser.getEmail(),

                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );
    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public GetUserResponse getU(Long userId) {
        // userId를 기반으로 실제 Repository에서 찾아 Entity에 넣기 + 예외처리
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("##### user id : " + userId + " 를 찾을 수 없습니다. #####")
        );

        // 응답dto 반환
        return new GetUserResponse(
                userEntity.getId(),

                userEntity.getUsername(),
                userEntity.getEmail(),

                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }

    // ---------------------------------------- 다건 조회 - GET ----------------------------------------
//    @Transactional(readOnly = true)
//    public List<GetUserResponse> getAllU() {
    // Repository 전체 조회 후 SchedulerEntity타입 List에 넣기
//        List<UserEntity> usersEntityList = userRepository.findAll();
//
    // 응답dto 타입의 List 선언
//        List<GetUserResponse> dtos = new ArrayList<>();

    // 전체 조회한 List를 순회, 각각의 Entity타입 데이터를 dto로 변환하여 응답객체 리스트에 담기
//        for (UserEntity userEntity : usersEntityList) {
//            GetUserResponse dto = new GetUserResponse(
//                    userEntity.getId(),
//
//                    userEntity.getUsername(),
//                    userEntity.getEmail(),
//
//                    userEntity.getCreatedAt(),
//                    userEntity.getUpdatedAt()
//            );
//            dtos.add(dto);
//        }
//        return dtos;
//    }
    @Transactional(readOnly = true)
    public List<GetUserResponse> getAllU() {
        // 스트림으로 간소화한 버전
        // Repository 전체 조회 -> Entity타입 List를 순회하며 Entity타입의 데이터를 dto타입으로 변환 -> 스트림을 순회 - 리스트에 담아서 반환
        return userRepository.findAll()
                .stream()
                .map(user -> new GetUserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()
                ))
                .toList();
    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @Transactional
    public UpdateUserResponse updateU(Long userId, UpdateUserRequest request) {
        // schedulerId를 기반으로 실제 Repository에서 찾아 Entity에 넣기 + 예외처리
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("##### user id : " + userId + " 를 찾을 수 없습니다. #####")
        );

        // 수정
        userEntity.update(request.getUsername(), request.getEmail());

        // 응답dto 반환
        return new UpdateUserResponse(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @Transactional
    public void deleteU(Long userId) {
        // id 존재여부 검사
        boolean existence = userRepository.existsById(userId);

        // 없을 경우 예외처리
        if (!existence) {
            throw new IllegalStateException("##### user id : " + userId + " 를 찾을 수 없습니다. #####");
        }

        // id기준 Repository에서 삭제
        userRepository.deleteById(userId);
    }
}

package com.schedulerv2.user.controller;

import com.schedulerv2.user.dto.*;
import com.schedulerv2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    // ############################################## 속성 필드 ##############################################
    // 하위 Layer 참조
    private final UserService userService;


    // ############################################## 메서드 ##############################################
    // ---------------------------------------- 유저 생성 - POST ----------------------------------------
    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createU(request));
    }

    // ---------------------------------------- 유저 단건 조회 - GET ----------------------------------------
    @GetMapping("/users/{userId}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getU(userId));
    }

    // ---------------------------------------- 유저 다건 조회 - GET ----------------------------------------
    @GetMapping("/scheduler")
    public ResponseEntity<List<GetUserResponse>> getAllUsers() { // @RequestParam(required=false) String xxx, Null 가능
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllU());    // .body( userService.search(xxx) );
    }

    // ---------------------------------------- 유저 수정 - PUT ----------------------------------------
    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateU(userId, request));
    }

    // ---------------------------------------- 유저 삭제 - DELETE ----------------------------------------
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteU(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

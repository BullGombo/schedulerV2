//package com.schedulerv2.login.controller;
//
//import com.schedulerv2.login.dto.LoginRequest;
//import com.schedulerv2.login.dto.LoginResponse;
//import com.schedulerv2.login.service.LoginService;
//import com.schedulerv2.user.entity.UserEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//public class LoginController {
//
//    private final LoginService loginService;
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
//
//        UserEntity user = loginService.login(request.getEmail(), request.getPassword());
//
//        return ResponseEntity.ok(
//                new LoginResponse(user.getId(), user.getUsername(), user.getEmail())
//        );
//    }
//}

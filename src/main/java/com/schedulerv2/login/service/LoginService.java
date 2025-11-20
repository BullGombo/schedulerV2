package com.schedulerv2.login.service;

import com.schedulerv2.login.LoginException;
import com.schedulerv2.user.entity.UserEntity;
import com.schedulerv2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public UserEntity login(String email, String password) {

        // 1) 이메일 존재 여부 확인
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new LoginException("존재하지 않는 이메일입니다."));

        // 2) 비밀번호 확인
        if (!user.getPassword().equals(password)) {
            throw new LoginException("비밀번호가 올바르지 않습니다.");
        }

        return user;
    }
}

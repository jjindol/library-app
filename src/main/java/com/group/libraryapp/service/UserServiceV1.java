package com.group.libraryapp.service;


import com.group.libraryapp.dto.user.UserCreateReq;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.UserUpdateReq;
import com.group.libraryapp.repository.UserJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceV1 { // controller가 객체로 변환한 것을 받음

    private final UserJdbcRepository userRepository;

    // user 생성
    public void saveUser(UserCreateReq request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    // user 반환
    public List<UserResponse> getUsers() {
        return userRepository.getUsers();
    }

    public void updateUser(UserUpdateReq request) {
        // 존재x -> 빈 리스트, 결과o -> 0 반환
        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);

    }

}

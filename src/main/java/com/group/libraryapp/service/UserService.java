package com.group.libraryapp.service;

import com.group.libraryapp.dto.request.UserCreateRequest;
import com.group.libraryapp.dto.request.UserUpdateRequest;
import com.group.libraryapp.dto.response.UserResponse;
import com.group.libraryapp.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }


    public List<UserResponse> getUsers() {
        return userRepository.getUsers();
    }


    public void updateUser(UserUpdateRequest request) {
        boolean isUserNotExist = userRepository.isUserNotExist(request.getId());

        if (isUserNotExist) {
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

package com.group.libraryapp.service;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.UserCreateReq;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.UserUpdateReq;
import com.group.libraryapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceV2 {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserCreateReq request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateReq request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalStateException::new);

        user.updateName(request.getName());
        userRepository.save(user); // Dirty Check -> 없어도 ok(변경 감지)
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findUserByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }
}


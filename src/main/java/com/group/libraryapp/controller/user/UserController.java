package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.UserCreateReq;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.UserUpdateReq;
import com.group.libraryapp.service.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user") // user 생성
    public void saveUser(@RequestBody UserCreateReq request) {
        userService.saveUser(request);
    }

    @GetMapping("/user") // user 반환
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateReq request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);

    }

}

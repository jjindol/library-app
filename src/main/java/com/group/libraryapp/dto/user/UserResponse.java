package com.group.libraryapp.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private long id;
    private String name;
    private Integer age;
}

package com.group.libraryapp.dto.user;


import lombok.Getter;

@Getter
public class UserCreateReq {

    private String name;
    private Integer age;

}
// int는 null 값을 표현할 수 없다
package com.group.libraryapp.dto.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {

    private String name;
    private Integer age; //null 표현 가능

}

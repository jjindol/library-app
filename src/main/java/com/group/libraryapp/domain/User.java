package com.group.libraryapp.domain;

import lombok.Getter;

@Getter
public class User {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 이름(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }
}

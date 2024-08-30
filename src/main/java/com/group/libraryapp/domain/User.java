package com.group.libraryapp.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20) // name varchar(20)
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<UserLoanHistory> histories = new ArrayList<>();

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 이름(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    protected User() {

    }

    public void updateName(String name) {
        this.name = name;
    }
}

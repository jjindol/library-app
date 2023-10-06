package com.group.libraryapp.service;

import com.group.libraryapp.dto.user.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService { // 현재 user 의 유무 파악 및 예외 처리

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
        String readSql = "select * from user where id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "update user set name = ? where id = ?"; // user 테이블에서 name 값을 특정한 값으로 업데이트
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }
}

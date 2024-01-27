package com.group.libraryapp.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public class BookMysqlRepository implements BookRepository{
    @Override
    public void saveBook() {
        System.out.println("MysqlRepository");
    }
}

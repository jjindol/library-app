package com.group.libraryapp.repository.book;

import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookMemoryRepository implements BookRepository {

    private final List<Book> books = new ArrayList<>();

    @Override
    public void saveBook() {

    }
}

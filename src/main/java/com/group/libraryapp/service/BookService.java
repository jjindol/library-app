package com.group.libraryapp.service;

import com.group.libraryapp.repository.BookMemoryRepository;
import com.group.libraryapp.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
        bookRepository.saveBook();
    }
}

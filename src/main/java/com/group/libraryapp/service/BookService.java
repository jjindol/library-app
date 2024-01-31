package com.group.libraryapp.service;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.dto.book.BookCreateReq;
import com.group.libraryapp.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void saveBook(BookCreateReq request) {
        bookRepository.save(new Book(request.getName()));
    }
}

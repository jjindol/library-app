package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.BookCreateReq;
import com.group.libraryapp.dto.book.BookLoanReq;
import com.group.libraryapp.dto.book.BookReturnReq;
import com.group.libraryapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public void saveBooks(@RequestBody BookCreateReq request) {
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBooks(@RequestBody BookLoanReq request) {
        bookService.loanBook(request);
    }

    @PutMapping("/book/return")
    public void returnBooks(@RequestBody BookReturnReq request) {
        bookService.returnBook(request);
    }
}

package com.group.libraryapp.service;

import com.group.libraryapp.domain.Book;
import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.book.BookCreateReq;
import com.group.libraryapp.dto.book.BookLoanReq;
import com.group.libraryapp.dto.user.UserLoanHistory;
import com.group.libraryapp.repository.BookRepository;
import com.group.libraryapp.repository.UserLoanHistoryRepository;
import com.group.libraryapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public void saveBook(BookCreateReq request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanReq request) {

        // 책 정보 가져오기
        Book book = bookRepository.findBookByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        // 대출중인지 확인 -> 대출중이면 예외 발생
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("대출되어 있는 책입니다.");
        }

        // 유저 정보 가져오기
        User user = userRepository.findUserByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 유저,책 정보를 기반으로 UserLoanHistory에 저장
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName(), false));


    }
}


package com.group.libraryapp.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public UserLoanHistory() { }

    public void doReturn() {
        this.isReturn = true;
    }
}

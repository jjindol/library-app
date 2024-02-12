package com.group.libraryapp.dto.user;

import com.group.libraryapp.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;
    // 0이면 대출중, 1이면 반납

    public UserLoanHistory(User user, String bookName, boolean isReturn) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = isReturn;
    }

    public void doReturn() {
        this.isReturn = true;
    }
}

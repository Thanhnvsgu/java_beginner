package com.thanhetn.thanhproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private Boolean isDeleted;
    private Long userId;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id.equals(account.id) &&
                Objects.equals(username, account.username) &&
                Objects.equals(password, account.password) &&
                Objects.equals(isDeleted, account.isDeleted) &&
                userId.equals(account.userId) &&
                user.equals(account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, user);
    }
}

package com.demo.dao;

import com.demo.model.Account;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountDAO {

    List<Account> accounts = Arrays.asList(
        new Account("user", "123", "User", "user@gmail.com", true, false),
        new Account("admin", "123", "Admin", "admin@gmail.com", true, true)
    );

    public Account getOne(String username){
        return accounts.stream()
                    .filter(a -> a.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
    }
}

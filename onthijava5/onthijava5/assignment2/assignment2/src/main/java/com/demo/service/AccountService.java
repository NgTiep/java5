package com.demo.service;

import com.demo.model.Account;
import com.demo.model.Category;
import com.demo.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    public void add(Account account) {
        accountRepo.save(account);
    }

    public void update(Account account) {
        accountRepo.save(account);
    }

    public void delete(String username) {
        accountRepo.deleteById(username);
    }

    public Account getOne(String username) {
        return accountRepo.findById(username).get();
    }
}

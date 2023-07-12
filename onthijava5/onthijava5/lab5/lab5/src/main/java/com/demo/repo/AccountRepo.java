package com.demo.repo;

import com.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO
public interface AccountRepo extends JpaRepository<Account, String> {
}

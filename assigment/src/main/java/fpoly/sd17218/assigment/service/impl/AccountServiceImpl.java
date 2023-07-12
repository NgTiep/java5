package fpoly.sd17218.assigment.service.impl;

import fpoly.sd17218.assigment.entity.Accounts;
import fpoly.sd17218.assigment.repository.AccountsRepository;
import fpoly.sd17218.assigment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public Page<Accounts> getAll(Pageable pageable) {
        return accountsRepository.findAll(pageable);
    }

    @Override
    public void add(Accounts accounts) {
        accountsRepository.save(accounts);
    }

    @Override
    public Accounts getOne(String username) {
        return accountsRepository.findById(username).get();
    }

    @Override
    public void delete(String username) {
        accountsRepository.deleteById(username);
    }

    @Override
    public void update(Accounts accounts) {
        accountsRepository.save(accounts);
    }

    @Override
    public List<Accounts> findAll() {
        return accountsRepository.findAll();
    }
}

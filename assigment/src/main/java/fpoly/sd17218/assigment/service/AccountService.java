package fpoly.sd17218.assigment.service;

import fpoly.sd17218.assigment.entity.Accounts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    Page<Accounts> getAll(Pageable pageable);

    void add(Accounts accounts);

    Accounts getOne(String username);

    void delete(String username);

    void update(Accounts accounts);

    List<Accounts> findAll();

}

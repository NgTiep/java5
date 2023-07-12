package fpoly.sd17218.assigment.service;

import fpoly.sd17218.assigment.entity.Accounts;
import fpoly.sd17218.assigment.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> getAll(Pageable pageable);

    void add(Product product);

    Product getOne(Integer id);

    void delete(Integer id);

    void update(Product product);

    List<Product> findAll();

}

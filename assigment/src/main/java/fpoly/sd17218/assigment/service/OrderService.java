package fpoly.sd17218.assigment.service;

import fpoly.sd17218.assigment.entity.Accounts;
import fpoly.sd17218.assigment.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    Page<Order> getAll(Pageable pageable);

    void add(Order order);

    Order getOne(Long id);

    void delete(Long id);

    void update(Order order);

    List<Order> findAll();

}

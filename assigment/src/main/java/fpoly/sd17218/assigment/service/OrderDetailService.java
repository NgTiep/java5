package fpoly.sd17218.assigment.service;

import fpoly.sd17218.assigment.entity.OrderDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDetailService {

    Page<OrderDetails> getAll(Pageable pageable);

    void add(OrderDetails orderDetails);

    OrderDetails getOne(Long id);

    void delete(Long id);

    void update(OrderDetails orderDetails);
}

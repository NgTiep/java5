package fpoly.sd17218.assigment.service.impl;

import fpoly.sd17218.assigment.entity.OrderDetails;
import fpoly.sd17218.assigment.repository.OrderDetailRepository;
import fpoly.sd17218.assigment.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public Page<OrderDetails> getAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public void add(OrderDetails orderDetails) {
        orderDetailRepository.save(orderDetails);
    }

    @Override
    public OrderDetails getOne(Long id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public void update(OrderDetails orderDetails) {
        orderDetailRepository.save(orderDetails);

    }
}

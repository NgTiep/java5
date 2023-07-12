package fpoly.sd17218.assigment.service.impl;

import fpoly.sd17218.assigment.entity.Product;
import fpoly.sd17218.assigment.repository.ProductRepository;
import fpoly.sd17218.assigment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getOne(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}

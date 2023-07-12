package fpoly.sd17218.assigment.service.impl;

import fpoly.sd17218.assigment.entity.Category;
import fpoly.sd17218.assigment.repository.CategoryRepository;
import fpoly.sd17218.assigment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void add(Category categories) {
        categoryRepository.save(categories);
    }

    @Override
    public Category getOne(String id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(Category categories) {
        categoryRepository.save(categories);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

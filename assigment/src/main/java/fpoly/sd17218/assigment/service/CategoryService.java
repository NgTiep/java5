package fpoly.sd17218.assigment.service;

import fpoly.sd17218.assigment.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    Page<Category> getAll(Pageable pageable);

    void add(Category category);

    Category getOne(String id);

    void delete(String id);

    void update(Category category);

    List<Category> findAll();

}

package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getOne(long id);

    void add(Category category);

    void delete(long id);

    void update(Category category);

    int viTri(List<Category>list, long id);
}

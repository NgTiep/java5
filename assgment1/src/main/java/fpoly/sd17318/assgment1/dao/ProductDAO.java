package fpoly.sd17318.assgment1.dao;

import fpoly.sd17318.assgment1.models.Category;
import fpoly.sd17318.assgment1.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO {

    List<Product> productList = new ArrayList<>();
    Category category1 = new CategoryDAO().findById(1);
    Category category2 = new CategoryDAO().findById(2);
    @Autowired
    CategoryDAO categoryDAO;

    public List<Product> getAll() {
        productList.add(new Product(1, "a", category1, 23));
        productList.add(new Product(2, "b", category2, 24));
        productList.add(new Product(3, "c", category1, 25));
        productList.add(new Product(4, "d", category2, 26));
        return productList;
    }

    public void addProduct(Product product) {
        int id = 1;
        if (productList.size() > 0) {
            id = productList.get(productList.size() - 1).getId() + 1;
        }

        product.setId(id);

        if (product.getCategory() != null) {
            Category category = categoryDAO.findById(product.getCategory().getId());
            product.setCategory(category);
        }

        productList.add(product);
    }

    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

//    public void updateProduct(Product product) {
//        if(product.getCategory() != null) {
//            Category category = categoryDAO.findById(product.getCategory().getId());
//            product.setCategory(category);
//        }
//
//        for(int i = 0; i < productList.size(); i++) {
//            if(product.getId() == productList.get(i).getId()) {
//                productList.set(i, product);
//            }
//        }
//    }

    public void delete(int id) {
//        productList = productList.stream()
//                        .filter(p -> p.getId() != id)
//                        .collect(Collectors.toList());
        Product viTri = findById(id);
        productList.remove(viTri);
    }

    public int viTri(List<Product> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Product update(List<Product> list, int id) {
        int viTri = viTri(list, id);
        return productList.get(viTri);
    }
}

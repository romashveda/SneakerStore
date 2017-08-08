package ua.home.service;


import ua.home.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService extends GeneralService<Product>{
    void add(Product product);

    void add(Product product, Integer brand,Integer category,Integer sex,Integer size,Integer color,Integer brandModel);

    void edit(Product product);

    Set<Product> searchProducts(String string);

    void delete(int id);

    Product findOne(int id);

    List<Product> findAll();

    Product findByModel(String model);

    List<Product> findBySex(String sex);

    List<Product> findByCategory(String sex,String category);

    List<Product> findSaleSneaker();

    List<Product> findByBrand(String brand);

}

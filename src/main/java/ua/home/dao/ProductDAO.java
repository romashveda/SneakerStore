package ua.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.home.entity.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Integer>{

    @Query("from Product p where p.model=:model")
    Product findByModel(@Param("model") String model);

    @Query("from Product p where p.sex.sexName=:sex")
    List<Product> findBySex(@Param("sex") String sex);

    @Query("from Product p where p.sex.sexName=:sex and p.category.categoryName=:category")
    List<Product> findByCategory(@Param("sex") String sex,@Param("category")String category);

    @Query("from Product p where p.onSale=true")
    List<Product> findSaleSneaker();

    @Query("from Product p where p.brand.brandName=:brand")
    List<Product> findByBrand(@Param("brand") String brand);

}

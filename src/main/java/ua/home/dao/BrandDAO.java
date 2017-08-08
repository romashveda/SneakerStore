package ua.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.home.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand,Integer>{
    @Query("from Brand b where b.brandName=:brandName")
    Brand findByName(@Param("brandName")String brandName);
}

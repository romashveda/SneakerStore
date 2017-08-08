package ua.home.service;


import ua.home.entity.Brand;

import java.util.List;

public interface BrandService extends GeneralService<Brand>{
    void add(Brand brand);
    void edit(Brand brand);
    void delete(int id);
    Brand findOne(int id);
    List<Brand> findAll();

    Brand findOneByName(String brandName);
}

package ua.home.service;


import ua.home.entity.BrandModel;

import java.util.List;

public interface BrandModelService extends GeneralService<BrandModel>{
    void add(BrandModel brandModel);

    void add(BrandModel brandModel, String brandName);

    void add(BrandModel brandModel, Integer id);

    void edit(BrandModel brandModel);

    void delete(int id);

    BrandModel findOne(int id);

    List<BrandModel> findAll();
}

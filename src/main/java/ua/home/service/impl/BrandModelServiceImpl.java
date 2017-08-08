package ua.home.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.BrandModelDAO;
import ua.home.entity.BrandModel;
import ua.home.service.BrandModelService;
import ua.home.service.BrandService;

import java.util.List;

@Service
@Transactional
public class BrandModelServiceImpl implements BrandModelService{

    @Autowired
    BrandService brandService;


    public void add(BrandModel brandModel, String brandName) {
        brandModel.setBrand(brandService.findOneByName(brandName));
        brandModelDAO.save(brandModel);
    }

    public void add(BrandModel brandModel, Integer id) {
        brandModel.setBrand(brandService.findOne(id));
        brandModelDAO.save(brandModel);
    }

    @Autowired
    BrandModelDAO brandModelDAO;

    public void add(BrandModel brandModel) {
        brandModelDAO.save(brandModel);
    }

    public void edit(BrandModel brandModel) {
        brandModelDAO.save(brandModel);
    }

    public void delete(int id) {
        brandModelDAO.delete(id);
    }

    public BrandModel findOne(int id) {
        return brandModelDAO.findOne(id);
    }

    public List<BrandModel> findAll() {
        return brandModelDAO.findAll();
    }
}

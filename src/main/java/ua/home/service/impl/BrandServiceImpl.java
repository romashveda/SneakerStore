package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.BrandDAO;
import ua.home.entity.Brand;
import ua.home.service.BrandService;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{

    @Autowired
    BrandDAO brandDAO;

    public void add(Brand brand) {
        brandDAO.save(brand);
    }

    public void edit(Brand brand) {
        brandDAO.save(brand);
    }

    public void delete(int id) {
        brandDAO.delete(id);
    }

    public Brand findOne(int id) {
        return brandDAO.findOne(id);
    }

    public Brand findOneByName(String brandName) {
        return brandDAO.findByName(brandName);
    }

    public List<Brand> findAll() {
        return brandDAO.findAll();
    }
}

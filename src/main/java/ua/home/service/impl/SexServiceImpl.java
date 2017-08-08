package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.SexDAO;
import ua.home.entity.Sex;
import ua.home.service.SexService;

import java.util.List;

@Service
@Transactional
public class SexServiceImpl implements SexService{

    @Autowired
    SexDAO sexDAO;

    public void add(Sex sex) {
        sexDAO.save(sex);
    }

    public void edit(Sex sex) {
        sexDAO.save(sex);
    }

    public void delete(int id) {
        sexDAO.delete(id);
    }

    public Sex findOne(int id) {
        return sexDAO.findOne(id);
    }

    public List<Sex> findAll() {
        return sexDAO.findAll();
    }

}

package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.SizeDAO;
import ua.home.entity.Size;
import ua.home.service.SizeService;

import java.util.List;

@Service
@Transactional
public class SizeServiceImpl implements SizeService{

    @Autowired
    SizeDAO sizeDAO;

    public void add(Size size) {
        sizeDAO.save(size);
    }

    public void edit(Size size) {
        sizeDAO.save(size);
    }

    public void delete(int id) {
        sizeDAO.delete(id);
    }

    public Size findOne(int id) {
        return sizeDAO.findOne(id);
    }

    public List<Size> findAll() {
        return sizeDAO.findAll();
    }
}

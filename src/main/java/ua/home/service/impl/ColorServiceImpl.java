package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.ColorDAO;
import ua.home.entity.Color;
import ua.home.service.ColorService;

import java.util.List;

@Service
@Transactional
public class ColorServiceImpl implements ColorService{

    @Autowired
    ColorDAO colorDAO;

    public void add(Color color) {
        colorDAO.save(color);
    }

    public void edit(Color color) {
        colorDAO.save(color);
    }

    public void delete(int id) {
        colorDAO.delete(id);
    }

    public Color findOne(int id) {
        return colorDAO.findOne(id);
    }

    public List<Color> findAll() {
        return colorDAO.findAll();
    }
}

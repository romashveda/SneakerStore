package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.CategoryDAO;
import ua.home.entity.Category;
import ua.home.service.CategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDAO categoryDAO;

    public void add(Category category) {
        categoryDAO.save(category);
    }

    public void edit(Category category) {
        categoryDAO.save(category);
    }

    public void delete(int id) {
        categoryDAO.delete(id);
    }

    public Category findOne(int id) {
        return categoryDAO.findOne(id);
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}

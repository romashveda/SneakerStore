package ua.home.service;


import ua.home.entity.Category;

import java.util.List;

public interface CategoryService extends GeneralService<Category>{
    void add(Category category);

    void edit(Category category);

    void delete(int id);

    Category findOne(int id);

    List<Category> findAll();
}
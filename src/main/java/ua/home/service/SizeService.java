package ua.home.service;


import ua.home.entity.Size;

import java.util.List;

public interface SizeService extends GeneralService<Size>{
    void add(Size size);

    void edit(Size size);

    void delete(int id);

    Size findOne(int id);

    List<Size> findAll();
}
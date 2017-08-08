package ua.home.service;


import ua.home.entity.Sex;

import java.util.List;

public interface SexService extends GeneralService<Sex>{
    void add(Sex sex);

    void edit(Sex sex);

    void delete(int id);

    Sex findOne(int id);

    List<Sex> findAll();
}

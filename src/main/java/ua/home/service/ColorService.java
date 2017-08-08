package ua.home.service;


import ua.home.entity.Color;

import java.util.List;

public interface ColorService extends GeneralService<Color>{
    void add(Color color);

    void edit(Color color);

    void delete(int id);

    Color findOne(int id);

    List<Color> findAll();
}

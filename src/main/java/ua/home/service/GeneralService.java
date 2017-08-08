package ua.home.service;


import java.util.List;

public interface GeneralService <E>{
    void add(E e);
    void edit(E e);
    void delete(int id);
    E findOne(int id);
    List<E> findAll();
}

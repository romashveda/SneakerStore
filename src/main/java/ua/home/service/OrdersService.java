package ua.home.service;


import ua.home.entity.Orders;
import ua.home.entity.Product;
import ua.home.entity.User;

import java.util.List;

public interface OrdersService extends GeneralService<Orders>{
    void add(Orders orders);

    void edit(Orders orders);

    void delete(int id);

    Orders findOne(int id);

    List<Orders> findAll();

    public void addToCurt();

    public List<Orders> findOrdersByUser(User user);

    Orders findOrderInCurt(List<Orders> ordersList);

    int calculatePrice(List<Product> products);
}

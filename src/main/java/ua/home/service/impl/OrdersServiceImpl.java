package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.OrdersDAO;
import ua.home.entity.Orders;
import ua.home.entity.Product;
import ua.home.entity.Status;
import ua.home.entity.User;
import ua.home.service.OrdersService;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    OrdersDAO ordersDAO;

    public void add(Orders orders) {
        ordersDAO.save(orders);
    }

    public void edit(Orders orders) {
        ordersDAO.save(orders);
    }

    public void delete(int id) {
        ordersDAO.delete(id);
    }

    public Orders findOne(int id) {
        return ordersDAO.findOne(id);
    }

    public List<Orders> findAll() {
        return ordersDAO.findAll();
    }

    public void addToCurt(){
    }

    public List<Orders> findOrdersByUser(User user) {
        return ordersDAO.findByUser(user.getUsername());
    }

    public Orders findOrderInCurt(List<Orders> ordersList) {
        Orders order = null;
        for (Orders o : ordersList) {
            if (o.getStatus().equals(Status.IN_CURT)) {
                order = o;
                break;
            }
        }
        return order;
    }

    public int calculatePrice(List<Product> products) {
        int price = 0;
        for (Product p: products) {
            price+=Integer.parseInt(p.getPrice());
        }
        return price;
    }
}

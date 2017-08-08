package ua.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.home.dao.OrdersDAO;
import ua.home.dao.UserDAO;
import ua.home.entity.Authority;
import ua.home.entity.Orders;
import ua.home.entity.User;
import ua.home.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    UserDAO userDAO;

    @Autowired
    OrdersDAO ordersDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void add(User user) {
        boolean var = true;
        if(userDAO.findAll().isEmpty()){
            user.setAuthority(Authority.ROLE_ADMIN);
        }else
            user.setAuthority(Authority.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccountNonExpired(var);
        user.setAccountNonLocked(var);
        user.setCredentialsNonExpired(var);
        user.setEnabled(var);
        List<Orders> ordersList = new ArrayList<Orders>();
        user.setOrdersList(ordersList);
        Orders order = new Orders(user);
        ordersList.add(order);
        userDAO.save(user);
        ordersDAO.save(order);
    }

    public void edit(User user) {
        userDAO.save(user);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }


    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}

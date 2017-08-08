package ua.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.home.entity.Orders;
import ua.home.entity.User;

import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders,Integer>{

    @Query("from Orders o where o.user.username=:user")
    List<Orders> findByUser(@Param("user")String user);
}

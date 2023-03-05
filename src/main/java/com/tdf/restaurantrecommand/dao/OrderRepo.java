package com.tdf.restaurantrecommand.dao;

import com.tdf.restaurantrecommand.model.entities.UserOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<UserOrders, String>{

    @Query("SELECT DISTINCT uo.userId from user_orders uo")
    List<String> findDistinctUserId();

    List<UserOrders> findAllByUserIdOrderByOrderIdDesc(String userId);
}

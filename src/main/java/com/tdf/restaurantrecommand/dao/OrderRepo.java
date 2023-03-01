package com.tdf.restaurantrecommand.dao;

import com.tdf.restaurantrecommand.model.entities.UserOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<UserOrders, String>{
}

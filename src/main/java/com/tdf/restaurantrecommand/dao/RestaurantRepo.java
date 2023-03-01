package com.tdf.restaurantrecommand.dao;

import com.tdf.restaurantrecommand.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {
}

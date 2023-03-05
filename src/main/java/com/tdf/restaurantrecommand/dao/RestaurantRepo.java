package com.tdf.restaurantrecommand.dao;

import com.tdf.restaurantrecommand.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {

    List<Restaurant> findAllByDateTimeOnboardedAfterOrderByDateTimeOnboarded(ZonedDateTime dateTime);
}

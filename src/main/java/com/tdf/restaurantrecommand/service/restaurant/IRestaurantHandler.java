package com.tdf.restaurantrecommand.service.restaurant;

import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @since 19
 * @author neeraj
 */
public interface IRestaurantHandler {

    List<Restaurant> getRestaurants(FilterType filterType, String filterValue);

    Restaurant addRestaurant(Restaurant restaurant);

}

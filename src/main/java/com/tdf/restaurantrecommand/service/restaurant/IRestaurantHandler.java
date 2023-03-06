package com.tdf.restaurantrecommand.service.restaurant;

import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @since 19
 * @author neeraj
 */
public interface IRestaurantHandler {

    List<Restaurant> getRestaurants(FilterType filterType, String filterValue);

    Restaurant addRestaurant(Restaurant restaurant);

    Set<Restaurant> getAllNewRestaurantsWithOnboardedWithin(long recommandationDelayInSeconds);

    Set<Restaurant> getAllRestaurantsByUserCuisineAndAvgRating(List<UserOrders> userOrders);
}

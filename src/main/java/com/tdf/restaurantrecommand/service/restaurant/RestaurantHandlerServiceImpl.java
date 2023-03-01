package com.tdf.restaurantrecommand.service.restaurant;

import com.tdf.restaurantrecommand.dao.RestaurantRepo;
import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestaurantHandlerServiceImpl implements IRestaurantHandler {

    private final RestaurantRepo restaurantRepo;
    @Override
    public List<Restaurant> getRestaurants(FilterType filterType, String filterValue) {

        switch (filterType){
            case ID -> {
                return restaurantRepo.findById(filterValue).stream().toList();
            }
            default -> {
                return Collections.EMPTY_LIST;
            }
        }
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurant.createIdForRestaurant();
        restaurantRepo.save(restaurant);
        return restaurant;
    }
}

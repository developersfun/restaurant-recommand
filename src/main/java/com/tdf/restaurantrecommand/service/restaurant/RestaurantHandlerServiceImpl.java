package com.tdf.restaurantrecommand.service.restaurant;

import com.tdf.restaurantrecommand.dao.RestaurantRepo;
import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
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

    @Override
    public List<Restaurant> getAllNewRestaurantsWithOnboardedWithin(long recommandationDelayInSeconds) {
        ZonedDateTime afterTime = ZonedDateTime.now(ZoneId.of("Etc/UTC")).minus(recommandationDelayInSeconds, ChronoUnit.SECONDS);
        return restaurantRepo.findAllByDateTimeOnboardedAfterOrderByDateTimeOnboarded(afterTime);
    }

    @Override
    public List<Restaurant> getAllRestaurantsByUserCuisineAndAvgRating(UserOrders userOrders) {
        return null;
    }
}

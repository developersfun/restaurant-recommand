package com.tdf.restaurantrecommand.service.restaurant;

import com.tdf.restaurantrecommand.dao.RestaurantRepo;
import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.dto.CuisineType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

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
    public Set<Restaurant> getAllNewRestaurantsWithOnboardedWithin(long recommandationDelayInSeconds) {
        ZonedDateTime afterTime = ZonedDateTime.now(ZoneId.of("Etc/UTC")).minus(recommandationDelayInSeconds, ChronoUnit.SECONDS);
        return restaurantRepo.findAllByDateTimeOnboardedAfterOrderByDateTimeOnboarded(afterTime).stream().limit(4).collect(Collectors.toSet());
    }

    @Override
    public Set<Restaurant> getAllRestaurantsByUserCuisineAndAvgRating(List<UserOrders> userOrders) {

        final Set<Restaurant> allSuggestedRestaurants = new HashSet<>();

        if(CollectionUtils.isEmpty(userOrders))
            return allSuggestedRestaurants;

        List<CuisineType> cuisineTypes = new ArrayList<>();
        List<Integer> costBrackets = new ArrayList<>();

        userOrders.stream().forEach(
                order -> {
                    cuisineTypes.add(order.getCuisineType());
                    costBrackets.add(order.getCostBracket());
                }
        );

        addAllPrimarySecondaryRestaurants(allSuggestedRestaurants, cuisineTypes, costBrackets);
        addAllSecondaryRestaurants(allSuggestedRestaurants, cuisineTypes, costBrackets);
        addAllRestaurants(allSuggestedRestaurants);

//        Could be async based on the load. not required for test data
//        CompletableFuture.runAsync(() -> addAllPrimarySecondaryRestaurants(allSuggestedRestaurants, cuisineTypes, costBrackets));
//        CompletableFuture.runAsync(() -> addAllSecondaryRestaurants(allSuggestedRestaurants, cuisineTypes, costBrackets));
//        CompletableFuture.runAsync(() -> addAllRestaurants(allSuggestedRestaurants));

        return allSuggestedRestaurants.stream().limit(96).collect(Collectors.toSet());
    }

    private void addAllRestaurants(Set<Restaurant> allSuggestedRestaurants) {
        allSuggestedRestaurants.addAll(
                restaurantRepo.findAll()
        );
    }

    private void addAllSecondaryRestaurants(Set<Restaurant> allSuggestedRestaurants, List<CuisineType> cuisineTypes, List<Integer> costBrackets) {

        allSuggestedRestaurants.addAll(restaurantRepo.findAllByCuisineTypeInAndCostBracketInAndRatingLessThan(
                cuisineTypes.get(0), costBrackets.get(0), 4.0,
                cuisineTypes.get((0 + cuisineTypes.size()-1)/2), costBrackets.get((0 + costBrackets.size()-1)/2), 4.5,
                cuisineTypes.get(cuisineTypes.size()-1), costBrackets.get(costBrackets.size()-1), 4.5));
    }

    private void addAllPrimarySecondaryRestaurants(Set<Restaurant> allSuggestedRestaurants, List<CuisineType> cuisineTypes, List<Integer> costBrackets) {
        allSuggestedRestaurants.addAll(restaurantRepo.findAllByCuisineTypeInAndCostBracketInAndRatingGreaterThan(
                cuisineTypes.get(0), costBrackets.get(0), 4.0,
                cuisineTypes.get((0 + cuisineTypes.size()-1)/2), costBrackets.get((0 + costBrackets.size()-1)/2), 4.5,
                cuisineTypes.get(cuisineTypes.size()-1), costBrackets.get(costBrackets.size()-1), 4.5));
    }
}

package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.dao.OrderRepo;
import com.tdf.restaurantrecommand.model.dto.FilterType;
import com.tdf.restaurantrecommand.model.entities.CuisineType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.model.entities.User;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderHandlerServiceImpl implements IOrderHandler {

    private final IRestaurantHandler restaurantHandlerServiceImpl;
    private final OrderRepo orderRepo;

    @Override
    public Map<String, Object> orderCuisineFromRestaurant(String userId, String restaurantId, CuisineType cuisineType) {
        String orderId = UUID.randomUUID().toString();

        List<Restaurant> restaurants = restaurantHandlerServiceImpl.getRestaurants(FilterType.ID, restaurantId);
        Restaurant restaurant = restaurants.stream().findFirst().orElseThrow(()->
                new RuntimeException("Restaurant not found")
        );

        if(!cuisineType.equals(restaurant.getCuisineType())){
            throw new RuntimeException("Cuisine " + cuisineType +" not provided by the Restaurant.");
        }

        UserOrders userOrders = createAndPersistUserOrder(orderId, userId, restaurant);

        return generateResponseMap(userOrders);
    }

    @Override
    public List<UserOrders> getUserCuisineAndRatingDetails(String userId) {
        return orderRepo.findAllByUserIdOrderByOrderIdDesc(userId);
    }

    private UserOrders createAndPersistUserOrder(String orderId, String userId, Restaurant restaurant) {
        UserOrders userOrder = UserOrders.builder()
                .orderId(orderId)
                .userId(userId)
                .restaurantId(restaurant.getId())
                .cuisineType(restaurant.getCuisineType())
                .costBracket(restaurant.getCostBracket())
                .orderDate(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Etc/UTC")))
                .build();

        orderRepo.save(userOrder);
        log.info("Order type {} created for user {} at restaurant {}.", restaurant.getCuisineType(), userId, restaurant.getId());

        return userOrder;
    }

    private Map<String, Object> generateResponseMap(UserOrders userOrders) {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("userId", userOrders.getUserId());
        orderMap.put("orderId", userOrders.getOrderId());
        orderMap.put("restaurantId", userOrders.getRestaurantId());
        orderMap.put("costBracket", userOrders.getCostBracket());
        orderMap.put("cuisineType", userOrders.getCuisineType());
        return orderMap;
    }
}

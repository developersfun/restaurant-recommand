package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConsumerReferenceServiceImpl implements IConsumerReference {

    private final IRestaurantHandler restaurantHandlerServiceImpl;
    private final IOrderHandler orderHandlerServiceImpl;

    @Override
    public Map<String, Set<Restaurant>> recommendRestaurantsByCategoryToUser(String userId) {

        List<UserOrders> topUserOrders = orderHandlerServiceImpl.getTopUserOrders(userId);

        Map<String, Set<Restaurant>> restaurantRecommandationMap = new HashMap<>(2,1);
        Set<Restaurant> userRecommendations = restaurantHandlerServiceImpl.getAllRestaurantsByUserCuisineAndAvgRating(topUserOrders);

        log.info("Total {} Recommanded Restaurants to user {} ",userRecommendations.size(), userId);
        restaurantRecommandationMap.put("RECOMMANDED_RESTAURANTS", userRecommendations);

        return restaurantRecommandationMap;
    }
}

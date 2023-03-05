package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConsumerReferenceServiceImpl implements IConsumerReference {

    private final IRestaurantHandler restaurantHandlerServiceImpl;
    private final IOrderHandler orderHandlerServiceImpl;

    @Override
    public Map<String, List<Restaurant>> recommandRestaurantsByCategoryToUser(String userId) {
        Map<String, List<Restaurant>> restaurantRecommandationMap = new HashMap<>(2,1);

        List<UserOrders> userOrders = orderHandlerServiceImpl.getUserCuisineAndRatingDetails(userId);
        log.info("User ordered {} dishes", userOrders.size());
        List<Restaurant> userRecommandations = restaurantHandlerServiceImpl.getAllRestaurantsByUserCuisineAndAvgRating(userOrders.get(0));
        restaurantRecommandationMap.put("RECOMMANDED_RESTAURANTS", userRecommandations);

        return restaurantRecommandationMap;
    }
}

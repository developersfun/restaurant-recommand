package com.tdf.restaurantrecommand.controller;

import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.service.consumer.IConsumerReference;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;


/**
 * Handles User Restaurant Recommendation Activities
 * @since 19
 * @author neeraj
 */
@RestController
@RequestMapping("/v1/recommend")
@RequiredArgsConstructor
public class RecommandationEngineController {

    private final IConsumerReference consumerReferenceServiceImpl;
    private final IRestaurantHandler restaurantHandlerServiceImpl;

    @Value("${rr.app.recommendationDelayInSeconds}")
    private long recommendationDelayInSeconds;

    @GetMapping
    public Map<String, Set<Restaurant>> recommendRestaurantsForUser(@RequestParam("userId") String userId){
        try{
            Map<String, Set<Restaurant>> restaurantRecommandationMap = consumerReferenceServiceImpl.recommendRestaurantsByCategoryToUser(userId);
            restaurantRecommandationMap.put("NEW_RESTAURANTS", restaurantHandlerServiceImpl.getAllNewRestaurantsWithOnboardedWithin(recommendationDelayInSeconds));
            return restaurantRecommandationMap;
        } catch (Exception e){
            //Internal Log and throw runtime exception.
            throw new RuntimeException("Cannot recommend Restaurants for user : " + userId);
        }
    }
}

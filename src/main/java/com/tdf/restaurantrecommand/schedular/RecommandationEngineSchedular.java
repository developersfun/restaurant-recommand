package com.tdf.restaurantrecommand.schedular;

import com.tdf.restaurantrecommand.dao.OrderRepo;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.service.consumer.IConsumerReference;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Need not be internal schedular, but event service required for automated recommendations to the users
 * @since 19
 * @author neeraj
 */
@EnableScheduling
@Component
@RequiredArgsConstructor
@Slf4j
public class RecommandationEngineSchedular {

    private final OrderRepo orderRepo;
    private final IConsumerReference consumerReferenceServiceImpl;
    private final IRestaurantHandler restaurantHandlerServiceImpl;
    @Value("${rr.app.recommendationDelayInSeconds}")
    private long recommendationDelayInSeconds;


    @Scheduled(fixedDelay = 60000)
    public void recommandRestaurantsToUsers() throws InterruptedException {
        //Somehow We got to know the Users List. For Simplicity, Using User Order's unique user Ids
        List<String> userIds = orderRepo.findDistinctUserId();
        //kept new restaurants out because list will be same for all users
        Set<Restaurant> newRestaurants = restaurantHandlerServiceImpl.getAllNewRestaurantsWithOnboardedWithin(recommendationDelayInSeconds);

        for (String userId: userIds) {
            Thread.sleep(10000);
            Map<String, Set<Restaurant>> restaurantRecommandationMap = consumerReferenceServiceImpl.recommendRestaurantsByCategoryToUser(userId);
            restaurantRecommandationMap.put("NEW_RESTAURANTS", newRestaurants);

            //Push/Email Notify user to his App insteap of plain console log
            log.info("Recommendation for user {} : {}", userId,restaurantRecommandationMap );
        }
    }
}

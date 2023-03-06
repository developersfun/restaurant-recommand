package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.model.dto.CuisineType;
import com.tdf.restaurantrecommand.model.entities.UserOrders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @since 19
 * @author neeraj
 */
@Component
public interface IOrderHandler {
    Map<String, Object> orderCuisineFromRestaurant(String userId, String restaurantId, CuisineType cuisineType);
    List<UserOrders> getUserCuisineAndRatingDetails(String userId);
    List<UserOrders> getTopUserOrders(String userId);
}

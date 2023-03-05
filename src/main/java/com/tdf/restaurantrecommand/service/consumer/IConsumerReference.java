package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.model.entities.Restaurant;

import java.util.List;
import java.util.Map;

public interface IConsumerReference {
    Map<String, List<Restaurant>> recommandRestaurantsByCategoryToUser(String userId);
}

package com.tdf.restaurantrecommand.service.consumer;

import com.tdf.restaurantrecommand.model.entities.Restaurant;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IConsumerReference {
    Map<String, Set<Restaurant>> recommendRestaurantsByCategoryToUser(String userId);
}

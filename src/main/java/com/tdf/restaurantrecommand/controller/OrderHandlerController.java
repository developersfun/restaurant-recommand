package com.tdf.restaurantrecommand.controller;

import com.tdf.restaurantrecommand.model.entities.CuisineType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import com.tdf.restaurantrecommand.service.consumer.IOrderHandler;
import com.tdf.restaurantrecommand.service.restaurant.IRestaurantHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * @since 19
 * @author neeraj
 */
@RestController
@AllArgsConstructor
@RequestMapping("/v1/order")
public class OrderHandlerController {
    private final IOrderHandler orderHandlerServiceImpl;

    @PostMapping
    public ResponseEntity<Object> orderDish(@RequestParam("userId") String userId,
                                             @RequestParam("restaurantId") String restaurantId,
                                             @RequestParam("cuisineType") CuisineType cuisineType) {
        try{
            Map<String, Object> orderMap = orderHandlerServiceImpl.orderCuisineFromRestaurant(
                    userId, restaurantId, cuisineType
            );
            return new ResponseEntity<>(orderMap, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

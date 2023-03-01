package com.tdf.restaurantrecommand.model.entities;

import lombok.Data;

@Data
public class User {

    private String userId;
    private CuisineTracking[]  cuisines;
    private CostTracking[] costBracket;
}

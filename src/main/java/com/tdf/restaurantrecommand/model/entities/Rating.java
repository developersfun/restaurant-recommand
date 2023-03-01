package com.tdf.restaurantrecommand.model.entities;

import java.util.List;

public class Rating {

    private String id;
    private String restaurantId;
    private transient Double averageRating;

    private transient List<Reviews> reviewsList;

}

package com.tdf.restaurantrecommand.model.entities;

public class Reviews {

    private String id;
    private String restaurantId;
    private String consumerId;
    private Double rating;
    private String review;

    public void setRating(Double rating) {
        if(rating>5.0 || rating<0.0)
                throw new RuntimeException("Rating should be between 0 and 5");
        this.rating = rating;
    }
}

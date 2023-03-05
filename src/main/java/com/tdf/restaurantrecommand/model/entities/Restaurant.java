package com.tdf.restaurantrecommand.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "restaurant")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    private String id;
    private String name;
    private String city;
    private String locality;
    private String address;
    private Boolean isRecommended = false;

    @Enumerated(EnumType.STRING)
    private CuisineType cuisineType;

    private ZonedDateTime dateTimeOnboarded;

    private Integer costBracket;

    private void setId(String id) {
        this.id = id;
    }

    public void createIdForRestaurant() {
        this.id = UUID.randomUUID().toString();
    }

    public void setCostBracket(Integer costBracket) {
        if(Objects.isNull(costBracket))
            this.costBracket = 0;
        else if(costBracket>5 || costBracket<0)
            throw new RuntimeException("Rating should be between 0 and 5");
        else this.costBracket = costBracket;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isRecommended=" + isRecommended +
                ", cuisineType=" + cuisineType +
                ", costBracket=" + costBracket +
                '}';
    }
}

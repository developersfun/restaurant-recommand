package com.tdf.restaurantrecommand.dao;

import com.tdf.restaurantrecommand.model.dto.CuisineType;
import com.tdf.restaurantrecommand.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {

    Set<Restaurant> findAllByDateTimeOnboardedAfterOrderByDateTimeOnboarded(ZonedDateTime dateTime);

    @Query("SELECT r FROM restaurant r WHERE cuisineType = ?1 AND costBracket=?2 and rating >= ?3 " +
            "OR cuisineType = ?4 AND costBracket = ?5 and rating >= ?6 " +
            "OR cuisineType = ?7 AND costBracket = ?8 and rating >= ?9 " )
    List<Restaurant> findAllByCuisineTypeInAndCostBracketInAndRatingGreaterThan(CuisineType cuisineTypePrimary,
                                                                                Integer costBracketPrimary,
                                                                                Double ratingPrimary,
                                                                                CuisineType cuisineTypeSecondary,
                                                                                Integer costBracketSecondary,
                                                                                Double ratingSecondary,
                                                                                CuisineType cuisineType2Secondary,
                                                                                Integer costBracket2Secondary,
                                                                                Double rating2Secondary);

    @Query("SELECT r FROM restaurant r WHERE cuisineType = ?1 AND costBracket=?2 and rating < ?3 " +
            "OR cuisineType = ?4 AND costBracket = ?5 and rating < ?6 " +
            "OR cuisineType = ?7 AND costBracket = ?8 and rating < ?9 " )
    List<Restaurant> findAllByCuisineTypeInAndCostBracketInAndRatingLessThan(CuisineType cuisineTypePrimary,
                                                                                Integer costBracketPrimary,
                                                                                Double ratingPrimary,
                                                                                CuisineType cuisineTypeSecondary,
                                                                                Integer costBracketSecondary,
                                                                                Double ratingSecondary,
                                                                                CuisineType cuisineType2Secondary,
                                                                                Integer costBracket2Secondary,
                                                                                Double rating2Secondary);
}

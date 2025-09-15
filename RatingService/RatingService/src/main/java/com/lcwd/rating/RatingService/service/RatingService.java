package com.lcwd.rating.RatingService.service;

import com.lcwd.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //list
    List<Rating>getRatings();

    //get all by userid
    List<Rating>getRatingByUserId(String userId);


    //get all by hotel
    List<Rating>getRatingByHotelId(String hotelId);
}

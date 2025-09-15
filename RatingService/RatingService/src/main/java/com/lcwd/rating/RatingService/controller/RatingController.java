package com.lcwd.rating.RatingService.controller;

import com.lcwd.rating.RatingService.entity.Rating;
import com.lcwd.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;


    //create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);

    }
    //get all
    @GetMapping
    public ResponseEntity<List<Rating>>getRatings(){
        return new ResponseEntity<>(ratingService.getRatings(),HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>>getRatingsByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId),HttpStatus.OK);
    }
    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingsByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId),HttpStatus.OK);
    }
}

package com.lcwd.hotel.HotelService.controller;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.services.HotelService;
import com.lcwd.hotel.HotelService.services.Impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.create(hotel), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel>createHotel(@PathVariable String id){
        return new ResponseEntity<>(hotelService.get(id), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Hotel>>getAll(){
        return new ResponseEntity<>(hotelService.getAll(),HttpStatus.OK);
    }

}

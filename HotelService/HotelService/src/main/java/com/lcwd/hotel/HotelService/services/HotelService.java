package com.lcwd.hotel.HotelService.services;

import com.lcwd.hotel.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get
    List<Hotel>getAll();

    //get by id
    Hotel get(String id);
}

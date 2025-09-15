package com.lcwd.hotel.HotelService.services.Impl;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.exception.ResouNotFoundException;
import com.lcwd.hotel.HotelService.repository.HotelRepository;
import com.lcwd.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
  @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResouNotFoundException("hotel with given id is not found"));
    }
}

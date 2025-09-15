package com.lcwd.user.service.UserService.external.services;

import com.lcwd.user.service.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
    @GetMapping("/hotel/{id}")
    Hotel getHotel(@PathVariable ("id") String id);
}

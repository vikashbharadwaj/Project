package com.lcwd.user.service.UserService.service.impl;

import com.lcwd.user.service.UserService.entity.Hotel;
import com.lcwd.user.service.UserService.entity.Rating;
import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.exception.UserNotFoundException;
import com.lcwd.user.service.UserService.external.services.HotelService;
import com.lcwd.user.service.UserService.repository.UserRepository;
import com.lcwd.user.service.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("user with given id not found"+userId));
        //localhost:8082/Rating/user/f2a53db3-1986-47bc-9266-d7240cd88ceb
        Rating [] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/Rating/user/"+user.getUserId(),Rating[].class);
        logger.info("{}",ratingOfUser);

      List<Rating> ratings= Arrays.stream(ratingOfUser).toList();
           List<Rating> ratingList = ratings.stream().map(rating -> {
              // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/" + rating.getHotelId(), Hotel.class);
               Hotel hotel = hotelService.getHotel(rating.getHotelId());
              // logger.info("response status code {}", forEntity.getStatusCode());
              rating.setHotel(hotel);
               return rating;
           }).toList();

           user.setRating(ratingList);

        return user;
    }
}

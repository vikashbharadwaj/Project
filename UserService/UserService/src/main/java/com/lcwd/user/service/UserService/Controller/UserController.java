package com.lcwd.user.service.UserService.Controller;

import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    int retryCount=1;
    //get by id
    @GetMapping("/{userId}")
  //  @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimitor",fallbackMethod ="ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Retry count: {}",retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);

    }
    public ResponseEntity<User>ratingHotelFallback(@PathVariable String userId,Exception ex){
       // logger.info("fallback is executed bcz service is down",ex.getMessage());
        User user=User.builder().email("vikas@gmail.com")
                .name("vikash")
                .about("this user is crested dummy")
                .userId("12345")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    //allget user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
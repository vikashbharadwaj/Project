package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entity.User;

import java.util.List;

public interface UserService {

//create
    User saveUser(User user);

    //get all
    List<User>getAllUser();

    User getUser(String userId);
}

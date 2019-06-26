package com.xhs.first.service;

import com.xhs.first.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    int insertUser(User user);

    User getUserForPhoneNumber(String phoneNumber);

    User getUser(int userId);

    List<User> getAllUser();
}
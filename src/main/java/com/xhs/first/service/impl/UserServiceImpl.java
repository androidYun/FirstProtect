package com.xhs.first.service.impl;

import com.xhs.first.dao.UserMapper;
import com.xhs.first.pojo.User;
import com.xhs.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    public User getUserForPhoneNumber(String phoneNumber) {
        return userMapper.selectByPhoneNumber(phoneNumber);
    }


    public User getUser(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

}

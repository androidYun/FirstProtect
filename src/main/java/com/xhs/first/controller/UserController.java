package com.xhs.first.controller;

import com.xhs.first.pojo.BaseMsg;
import com.xhs.first.pojo.User;
import com.xhs.first.service.impl.UserServiceImpl;
import com.xhs.first.utils.StringUtils;
import com.xhs.first.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg userlogin(String phoneNumber,
                              String password) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return BaseMsg.getErrorMessageBean("手机号不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return BaseMsg.getErrorMessageBean("密码不能为空");
        }
        User userForPhoneNumber = userService.getUserForPhoneNumber(phoneNumber);
        if (userForPhoneNumber == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        } else if (!userForPhoneNumber.getPassword().equals(password)) {
            return BaseMsg.getErrorMessageBean("密码不正确");
        }

        return BaseMsg.getErrorMessageBean("获取数据失败");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    private BaseMsg<String> userRegister(String phoneNumber,
                                         String userName,
                                         String password,
                                         String deviceNo,
                                         int role) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return BaseMsg.getErrorMessageBean("手机号不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return BaseMsg.getErrorMessageBean("密码不能为空");
        }
        if (StringUtils.isEmpty(deviceNo)) {
            return BaseMsg.getErrorMessageBean("设备编号不能为空");
        }
        if (StringUtils.isEmpty(userName)) {
            return BaseMsg.getErrorMessageBean("用户名不能为空");
        }
        User userForPhoneNumber = userService.getUserForPhoneNumber(phoneNumber);
        if (userForPhoneNumber != null) {
            return BaseMsg.getErrorMessageBean("用户已存在");
        }
        User user = new User();
        user.setUserPhone(phoneNumber);
        user.setPassword(password);
        user.setUserName(userName);
        user.setDeviceNo(deviceNo);
        user.setCreateTime(TimeUtils.getCurrentDate());
        user.setRole(role);
        int insertRecord = userService.insertUser(user);
        if (insertRecord != 0) {
            return new BaseMsg().getSuccessData("注册成功");
        } else {
            return BaseMsg.getErrorMessageBean("注册失败");
        }
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PATCH)
    @ResponseBody
    private BaseMsg getUser(@PathVariable int userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        } else {
            return new BaseMsg().getSuccessData(user);
        }
    }

    @RequestMapping(value = "/getAll/{userId}", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg getAllUser(@PathVariable int userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        } else if (user.getRole() != 0) {
            return BaseMsg.getErrorMessageBean("权限不够");
        }
        return new BaseMsg(userService.getAllUser());
    }

    @RequestMapping(value = "/changeRole/{userId}", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg updateUserRole(@PathVariable int userId, int role) {
        System.out.println("参数" + role + "      " + userId);
        User user = userService.getUser(userId);
        if (user == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        }
        user.setRole(role);
        int updateCount = userService.updateUser(user);
        if (updateCount != 0) {
            return new BaseMsg("更新成功");
        } else {
            return BaseMsg.getErrorMessageBean("更改权限失败");
        }
    }

    @RequestMapping(value = "/changeHeadUrl/{userId}", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg updateUserHeadUrl(@PathVariable int userId, String headUrl) {
        if (StringUtils.isEmpty(headUrl)) {
            return BaseMsg.getErrorMessageBean("头像不能为空");
        }
        User user = userService.getUser(userId);
        if (user == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        }
        user.setHeadUrl(headUrl);
        int updateCount = userService.updateUser(user);
        if (updateCount != 0) {
            return new BaseMsg("更新成功");
        } else {
            return BaseMsg.getErrorMessageBean("更改权限失败");
        }
    }

    @RequestMapping(value = "/changePassword/{userId}", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg updateUserHeadUrl(@PathVariable int userId, String oldPassword, String newPassword) {
        if (StringUtils.isEmpty(oldPassword)) {
            return BaseMsg.getErrorMessageBean("旧密码不能为空");
        }
        if (StringUtils.isEmpty(newPassword)) {
            return BaseMsg.getErrorMessageBean("新密码不能为空");
        }
        User user = userService.getUser(userId);
        if (user == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        } else if (!user.getPassword().equals(oldPassword)) {
            return BaseMsg.getErrorMessageBean("老密码错误");
        }
        user.setPassword(newPassword);
        int updateCount = userService.updateUser(user);
        if (updateCount != 0) {
            return new BaseMsg("更新成功");
        } else {
            return BaseMsg.getErrorMessageBean("更改权限失败");
        }
    }
}

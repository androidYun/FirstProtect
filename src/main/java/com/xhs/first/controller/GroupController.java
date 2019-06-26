package com.xhs.first.controller;

import com.xhs.first.pojo.BaseMsg;
import com.xhs.first.pojo.ProtectGroup;
import com.xhs.first.pojo.User;
import com.xhs.first.service.impl.GroupServiceImpl;
import com.xhs.first.service.impl.UserServiceImpl;
import com.xhs.first.utils.StringUtils;
import com.xhs.first.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseMsg addGroup(String groupName,
                            String groupDesc) {
        if (StringUtils.isEmpty(groupName)) {
            return BaseMsg.getErrorMessageBean("组名不能为空");
        }
        ProtectGroup group = groupService.getGroup(groupName);
        if (group != null) {
            return BaseMsg.getErrorMessageBean("此分组已经存在");
        }
        ProtectGroup insertGroup = new ProtectGroup();
        insertGroup.setGroupName(groupName);
        insertGroup.setCreateTime(TimeUtils.getCurrentDate());
        insertGroup.setGroupDesc(groupDesc);
        int insertCount = groupService.insertGroup(insertGroup);
        if (insertCount != 0) {
            return new BaseMsg().getSuccessData("添加成功");
        } else {
            return BaseMsg.getErrorMessageBean("添加失败");
        }
    }

    @RequestMapping(value = "/getAll/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseMsg addGroup(@PathVariable int userId) {

        User user = userService.getUser(userId);
        if (user == null) {
            return BaseMsg.getErrorMessageBean("此用户不存在");
        }
        List<ProtectGroup> allGroup = groupService.getAllGroup(userId);


        return new BaseMsg().getSuccessData(allGroup);
    }
}

package com.xhs.first.service;

import com.xhs.first.pojo.ProtectGroup;

import java.util.List;

public interface GroupService {

    int insertGroup(ProtectGroup group);

    List<ProtectGroup>  getAllGroup(int userId);


    ProtectGroup getGroup(String groupName);

    ProtectGroup getGroupByGroupId(int groupId);

}

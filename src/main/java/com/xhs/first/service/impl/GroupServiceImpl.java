package com.xhs.first.service.impl;

import com.xhs.first.dao.ProtectGroupMapper;
import com.xhs.first.pojo.ProtectGroup;
import com.xhs.first.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    ProtectGroupMapper groupMapper;

    public int insertGroup(ProtectGroup group) {
        return groupMapper.insert(group);
    }

    public ProtectGroup getGroup(String groupName) {
        return groupMapper.selectByGroupName(groupName);
    }

    public ProtectGroup getGroupByGroupId(int groupId) {
        return groupMapper.selectByPrimaryKey(groupId);
    }

    public List<ProtectGroup> getAllGroup(int userId) {
        return groupMapper.selectAllGroup(userId);
    }
}

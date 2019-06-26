package com.xhs.first.dao;

import com.xhs.first.pojo.ProtectGroup;

import java.util.List;

public interface ProtectGroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(ProtectGroup record);

    int insertSelective(ProtectGroup record);

    ProtectGroup selectByPrimaryKey(Integer groupId);

    List<ProtectGroup> selectAllGroup(int userId);

    ProtectGroup selectByGroupName(String groupName);

    int updateByPrimaryKeySelective(ProtectGroup record);

    int updateByPrimaryKey(ProtectGroup record);
}
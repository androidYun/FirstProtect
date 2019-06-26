package com.xhs.first.dao;

import com.xhs.first.pojo.Protect;

import java.util.List;

public interface ProtectMapper {
    int deleteByPrimaryKey(Integer protectId);

    int insert(Protect record);

    int insertSelective(Protect record);

    Protect selectByName(String protectName);

    Protect selectByPrimaryKey(Integer protectId);

    List<Protect> getProtectListById(List<Integer> protectId);


    int updateByPrimaryKeySelective(Protect record);

    int updateByPrimaryKey(Protect record);
}
package com.xhs.first.service.impl;

import com.xhs.first.dao.ProtectMapper;
import com.xhs.first.pojo.Protect;
import com.xhs.first.service.ProtectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtectServiceImpl implements ProtectService {
    @Autowired
    ProtectMapper protectMapper;

    public int addProtect(Protect protect) {
        return protectMapper.insert(protect);
    }

    public Protect getProtectByName(String protectName) {
        return protectMapper.selectByName(protectName);
    }

    public List<Protect> getProtectById(List<Integer> idList) {
        System.out.println("插入数据当中");
        return protectMapper.getProtectListById(idList);
    }

    public boolean isListAllExist(List<Integer> idList) {
        List<Protect> protectList = protectMapper.getProtectListById(idList);
        if (protectList == null || protectList.size() != idList.size()) {
            return false;
        } else {
            return true;
        }
    }
}

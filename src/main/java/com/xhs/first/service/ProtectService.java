package com.xhs.first.service;

import com.xhs.first.pojo.Protect;

import java.util.List;

public interface ProtectService {

    int addProtect(Protect protect);

    Protect getProtectByName(String protectName);

    List<Protect> getProtectById(List<Integer> idList);

    boolean isListAllExist(List<Integer> idList);
}

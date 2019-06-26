package com.xhs.first.service;

import com.xhs.first.dao.ItemCartMapper;
import com.xhs.first.pojo.ItemCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCartServiceImpl implements ItemCartService {

    @Autowired
    ItemCartMapper itemCartMapper;

    public int insertItemCartList(List<ItemCart> itemCartList) {
        return itemCartMapper.insertItemCartList(itemCartList);
    }
}

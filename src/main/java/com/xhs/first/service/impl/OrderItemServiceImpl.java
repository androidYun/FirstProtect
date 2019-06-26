package com.xhs.first.service.impl;

import com.xhs.first.dao.OrderItemMapper;
import com.xhs.first.pojo.OrderItem;
import com.xhs.first.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;

    public int insertOrderItem(List<OrderItem> orderItems) {
        return orderItemMapper.insertOrderItemList(orderItems);
    }
}

package com.xhs.first.service;

import com.xhs.first.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    int insertOrderItem(List<OrderItem> orderItems);
}

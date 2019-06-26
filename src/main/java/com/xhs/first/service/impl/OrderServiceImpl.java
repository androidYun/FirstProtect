package com.xhs.first.service.impl;

import com.xhs.first.dao.OrderItemMapper;
import com.xhs.first.dao.ShopOrderMapper;
import com.xhs.first.pojo.OrderItem;
import com.xhs.first.pojo.ShopOrder;
import com.xhs.first.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    ShopOrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    public int createOrder(ShopOrder shopOrder) {
        return orderMapper.insert(shopOrder);
    }

    public List<ShopOrder> getOrderList(int userId) {
        return orderMapper.selectOrderListByUserId(userId);
    }

    public int deleteOrderById(int orderId) {
        int i = orderItemMapper.deleteByOrderId(orderId);
        return orderMapper.deleteByPrimaryKey(orderId);
    }
}

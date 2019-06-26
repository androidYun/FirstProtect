package com.xhs.first.controller;

import com.xhs.first.entity.CreateOrder;
import com.xhs.first.entity.ProtectEntity;
import com.xhs.first.pojo.*;
import com.xhs.first.service.impl.OrderItemServiceImpl;
import com.xhs.first.service.impl.OrderServiceImpl;
import com.xhs.first.service.impl.ProtectServiceImpl;
import com.xhs.first.service.impl.ShopCartServiceImpl;
import com.xhs.first.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/order")
@Controller
public class OrderController {


    @Autowired
    ShopCartServiceImpl shopCartService;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ProtectServiceImpl protectService;

    @Autowired
    OrderItemServiceImpl orderItemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    private BaseMsg createOrder(@RequestBody CreateOrder createOrder) {
        System.out.println("数据" + createOrder.getCartId());
        if (createOrder.getProtectEntities() == null || createOrder.getProtectEntities().size() == 0) {
            return BaseMsg.getErrorMessageBean("请选择要购买的物品");
        }
        ShopCart shopCart = shopCartService.selectById(createOrder.getCartId());
        if (shopCart == null) {
            return BaseMsg.getErrorMessageBean("此购物车可能不存在或者已经创建完毕");
        }
        List<Protect> protectList = protectService.getProtectById(getProtectIdList(createOrder.getProtectEntities()));
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setNumber(calculateProtectNumber(createOrder.getProtectEntities()));
        shopOrder.setAmount(50L);
        shopOrder.setCreateTime(TimeUtils.getCurrentDate());
        shopOrder.setState(0);
        shopOrder.setUserId(1);
        int orderId = orderService.createOrder(shopOrder);
        List<OrderItem> createItemCartList = new ArrayList<OrderItem>();
        for (int i = 0; i < createOrder.getProtectEntities().size(); i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCreateTime(TimeUtils.getCurrentDate());
            orderItem.setItemAmount(calculateAmount(createOrder.getProtectEntities().get(i).getNumber(),
                    getProtectPrice(protectList, createOrder.getProtectEntities().get(i).getProtectId())));
            orderItem.setOrderId(orderId);
            orderItem.setNumber(createOrder.getProtectEntities().get(i).getNumber());
            orderItem.setProtectId(createOrder.getProtectEntities().get(i).getProtectId());
            createItemCartList.add(orderItem);
        }
        int insertOrderItemCount = orderItemService.insertOrderItem(createItemCartList);
        shopCartService.deleteShopCart(createOrder.getCartId());
        if (insertOrderItemCount != 0) {
            return new BaseMsg().getSuccessData("添加成功");
        } else {
            return BaseMsg.getErrorMessageBean("添加失败");
        }
    }

    @RequestMapping(value = "/getAll/{userId}", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg getAllOrder(@PathVariable int userId) {
        List<ShopOrder> orderList = orderService.getOrderList(userId);
        if (orderList.size() != 0) {
            return new BaseMsg().getSuccessData(orderList);
        } else {
            return BaseMsg.getErrorMessageBean("获取订单失败");
        }
    }

    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.DELETE)
    @ResponseBody
    private BaseMsg deleteOrder(@PathVariable int orderId) {
        int deleteOrderCount = orderService.deleteOrderById(orderId);
        if (deleteOrderCount != 0) {
            return new BaseMsg().getSuccessData("删除成功");
        } else {
            return BaseMsg.getErrorMessageBean("获取订单不存在");
        }
    }


    private int calculateProtectNumber(List<ProtectEntity> protectEntities) {
        int allNumber = 0;
        for (int i = 0; i < protectEntities.size(); i++) {
            allNumber += protectEntities.get(i).getNumber();
        }
        return allNumber;
    }

    private BigDecimal calculateAmount(int number, BigDecimal price) {
        return new BigDecimal(number).multiply(price);
    }

    private List<Integer> getProtectIdList(List<ProtectEntity> protectEntities) {
        List<Integer> protectIdList = new ArrayList<Integer>();
        for (int i = 0; i < protectEntities.size(); i++) {
            protectIdList.add(protectEntities.get(i).getProtectId());
        }
        return protectIdList;
    }

    private BigDecimal getProtectPrice(List<Protect> protectList, int protectId) {
        for (int i = 0; i < protectList.size(); i++) {
            if (protectList.get(i).getProtectId() == protectId) {
                return protectList.get(i).getPrice();
            }
        }
        return new BigDecimal(0);
    }
}

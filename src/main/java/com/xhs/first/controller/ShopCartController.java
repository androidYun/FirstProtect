package com.xhs.first.controller;

import com.xhs.first.entity.CreateShopCart;
import com.xhs.first.entity.ProtectEntity;
import com.xhs.first.pojo.BaseMsg;
import com.xhs.first.pojo.ItemCart;
import com.xhs.first.pojo.Protect;
import com.xhs.first.pojo.ShopCart;
import com.xhs.first.service.ItemCartServiceImpl;
import com.xhs.first.service.impl.ProtectServiceImpl;
import com.xhs.first.service.impl.ShopCartServiceImpl;
import com.xhs.first.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class ShopCartController {

    @Autowired
    private ShopCartServiceImpl shopCartService;

    @Autowired
    private ProtectServiceImpl protectService;

    @Autowired
    private ItemCartServiceImpl itemCartService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    private BaseMsg addShopCart(@RequestBody CreateShopCart createShopCart) {
        if (createShopCart == null || createShopCart.getProtectEntityList() == null || createShopCart.getProtectEntityList().size() == 0) {
            return BaseMsg.getErrorMessageBean("数据不能为空");
        }
        boolean isListAllExist = protectService.isListAllExist(getProtectIdList(createShopCart.getProtectEntityList()));
        if (!isListAllExist) {
            return BaseMsg.getErrorMessageBean("有的物品不存在");
        }
        ShopCart shopCart = new ShopCart();
        shopCart.setUserId(2);
        shopCart.setCreateTime(TimeUtils.getCurrentDate());
        shopCart.setAmount(new BigDecimal(20));
        int shopCartId = shopCartService.insertShopCart(shopCart);
        List<Protect> protectList = protectService.getProtectById(getProtectIdList(createShopCart.getProtectEntityList()));
        System.out.println("查看日志" + shopCartId);
        if (shopCartId < 0) {
            return BaseMsg.getErrorMessageBean("创建失败");
        }
        List<ItemCart> createItemCartList = new ArrayList<ItemCart>();
        for (int i = 0; i < createShopCart.getProtectEntityList().size(); i++) {
            ItemCart itemCart = new ItemCart();
            itemCart.setCreateTime(TimeUtils.getCurrentDate());
            itemCart.setItemAmount(calculateAmount(protectList, createShopCart.getProtectEntityList().get(i).getProtectId()));
            itemCart.setCartId(shopCartId);
            itemCart.setNumber(createShopCart.getProtectEntityList().get(i).getNumber());
            itemCart.setProtectId(createShopCart.getProtectEntityList().get(i).getProtectId());
            createItemCartList.add(itemCart);
        }
        int insertCount = itemCartService.insertItemCartList(createItemCartList);
        if (insertCount != 0) {
            return new BaseMsg().getSuccessData("添加成功");
        } else {
            return BaseMsg.getErrorMessageBean("添加失败");
        }
    }

    @RequestMapping(value = "/getAll/{userId}", method = RequestMethod.GET)
    @ResponseBody
    private BaseMsg getOrder(@PathVariable int userId) {
        List<ShopCart> shopCartList = shopCartService.getShopCartListById(userId);
        if (shopCartList != null) {
            return new BaseMsg().getSuccessData(shopCartList);
        } else {
            return BaseMsg.getErrorMessageBean("获取订单失败");
        }
    }

    @RequestMapping(value = "/delete/{cartId}", method = RequestMethod.DELETE)
    @ResponseBody
    private BaseMsg deleteOrder(@PathVariable int cartId) {
        int deleteCartCount = shopCartService.deleteShopCart(cartId);
        if (deleteCartCount != 0) {
            return new BaseMsg().getSuccessData("删除成功");
        } else {
            return BaseMsg.getErrorMessageBean("获取订单失败");
        }
    }

    private List<Integer> getProtectIdList(List<ProtectEntity> protectEntities) {
        List<Integer> protectIdList = new ArrayList<Integer>();
        for (int i = 0; i < protectEntities.size(); i++) {
            protectIdList.add(protectEntities.get(i).getProtectId());
        }
        return protectIdList;
    }

    private BigDecimal calculateAmount(List<Protect> protectList, int protectId) {
        for (int i = 0; i < protectList.size(); i++) {
            if (protectList.get(i).getProtectId() == protectId) {
                return protectList.get(i).getPrice().multiply(new BigDecimal(protectList.get(i).getNumber()));
            }
        }
        return new BigDecimal(0);
    }
}

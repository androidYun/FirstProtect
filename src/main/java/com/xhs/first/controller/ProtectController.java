package com.xhs.first.controller;


import com.xhs.first.pojo.BaseMsg;
import com.xhs.first.pojo.Protect;
import com.xhs.first.pojo.ProtectGroup;
import com.xhs.first.service.impl.GroupServiceImpl;
import com.xhs.first.service.impl.ProtectServiceImpl;
import com.xhs.first.utils.StringUtils;
import com.xhs.first.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/protect")
public class ProtectController {
    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    ProtectServiceImpl protectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseMsg addProtect(Protect protect) {
        if (StringUtils.isEmpty(protect.getProtectName())) {
            return BaseMsg.getErrorMessageBean("产品名字不能为空");
        }
        if (StringUtils.isEmpty(protect.getImageUrl())) {
            return BaseMsg.getErrorMessageBean("图片不能为空");
        }
        if (protect.getNumber() == null || protect.getNumber() == 0) {
            protect.setNumber(Integer.MAX_VALUE);
        }
        if (protect.getPrice() == null || protect.getPrice() == new BigDecimal(0)) {
            return BaseMsg.getErrorMessageBean("价格不能为空");
        }
        ProtectGroup group = groupService.getGroupByGroupId(protect.getGroupId());
        if (group == null) {
            return BaseMsg.getErrorMessageBean("此分组不存在");
        }
        Protect selectProtect = protectService.getProtectByName(protect.getProtectName());
        if (selectProtect != null) {
            return BaseMsg.getErrorMessageBean("此商品已经存在");
        }
        protect.setCreateTime(TimeUtils.getCurrentDate());
        int insertCount = protectService.addProtect(protect);
        if (insertCount != 0) {
            return new BaseMsg().getSuccessData("添加成功");
        } else {
            return BaseMsg.getErrorMessageBean("添加失败");
        }
    }


}

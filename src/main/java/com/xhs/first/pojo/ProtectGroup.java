package com.xhs.first.pojo;

import java.util.Date;
import java.util.List;

public class ProtectGroup {
    private Integer groupId;

    private String groupName;

    private Date createTime;

    private String groupDesc;

    private List<Protect> protectList;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc == null ? null : groupDesc.trim();
    }


    public List<Protect> getProtectList() {
        return protectList;
    }

    public void setProtectList(List<Protect> protectList) {
        this.protectList = protectList;
    }
}
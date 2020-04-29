package com.zyzl.weixin.bean;

import java.util.List;

public class TagWechatUserParam extends WechatAccountInfo {

    private String originalId;
    private Integer tagId;
    private List<String> openIdList;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public List<String> getOpenIdList() {
        return openIdList;
    }

    public void setOpenIdList(List<String> openIdList) {
        this.openIdList = openIdList;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

}

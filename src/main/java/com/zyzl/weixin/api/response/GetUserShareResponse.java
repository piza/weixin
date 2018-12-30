package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UserShare;

import java.util.List;

/**
 * @author peter
 */
public class GetUserShareResponse extends BaseResponse {

    private List<UserShare> list;

    public List<UserShare> getList() {
        return list;
    }

    public void setList(List<UserShare> list) {
        this.list = list;
    }
}

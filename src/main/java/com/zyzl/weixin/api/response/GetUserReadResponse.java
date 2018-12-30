package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UserRead;

import java.util.List;

/**
 * @author peter
 */
public class GetUserReadResponse extends BaseResponse {

    private List<UserRead> list;

    public List<UserRead> getList() {
        return list;
    }

    public void setList(List<UserRead> list) {
        this.list = list;
    }
}

package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UserCumulate;

import java.util.List;

/**
 * @author peter
 */
public class GetUserCumulateResponse extends BaseResponse {

    private List<UserCumulate> list;

    public List<UserCumulate> getList() {
        return list;
    }

    public void setList(List<UserCumulate> list) {
        this.list = list;
    }
}

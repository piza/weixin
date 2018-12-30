package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UserSummary;

import java.util.List;

/**
 * @author peter
 */
public class GetUserSummaryResponse extends BaseResponse {

    private List<UserSummary> list;

    public List<UserSummary> getList() {
        return list;
    }

    public void setList(List<UserSummary> list) {
        this.list = list;
    }
}

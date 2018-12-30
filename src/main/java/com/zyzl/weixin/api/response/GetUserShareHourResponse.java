package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UserShareHour;

import java.util.List;

/**
 * @author peter
 */
public class GetUserShareHourResponse extends BaseResponse {

    private List<UserShareHour> list;

    public List<UserShareHour> getList() {
        return list;
    }

    public void setList(List<UserShareHour> list) {
        this.list = list;
    }
}

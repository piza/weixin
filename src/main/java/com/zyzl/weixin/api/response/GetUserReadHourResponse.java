package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UserReadHour;

import java.util.List;

/**
 * @author peter
 */
public class GetUserReadHourResponse extends BaseResponse {

    private List<UserReadHour> list;

    public List<UserReadHour> getList() {
        return list;
    }

    public void setList(List<UserReadHour> list) {
        this.list = list;
    }
}

package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsgDistWeek;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgDistWeekResponse extends BaseResponse {

    private List<UpstreamMsgDistWeek> list;

    public List<UpstreamMsgDistWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistWeek> list) {
        this.list = list;
    }
}

package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsgWeek;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgWeekResponse extends BaseResponse {

    private List<UpstreamMsgWeek> list;

    public List<UpstreamMsgWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgWeek> list) {
        this.list = list;
    }
}

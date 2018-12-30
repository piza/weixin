package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsgHour;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgHourResponse extends BaseResponse {

    private List<UpstreamMsgHour> list;

    public List<UpstreamMsgHour> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgHour> list) {
        this.list = list;
    }
}

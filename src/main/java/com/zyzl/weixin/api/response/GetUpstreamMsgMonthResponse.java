package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsgMonth;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgMonthResponse extends BaseResponse {

    private List<UpstreamMsgMonth> list;

    public List<UpstreamMsgMonth> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgMonth> list) {
        this.list = list;
    }
}

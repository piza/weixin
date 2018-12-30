package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsgDistMonth;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgDistMonthResponse extends BaseResponse {

    private List<UpstreamMsgDistMonth> list;

    public List<UpstreamMsgDistMonth> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistMonth> list) {
        this.list = list;
    }
}

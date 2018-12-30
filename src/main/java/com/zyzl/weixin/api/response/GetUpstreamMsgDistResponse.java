package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsgDist;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgDistResponse extends BaseResponse {

    private List<UpstreamMsgDist> list;

    public List<UpstreamMsgDist> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDist> list) {
        this.list = list;
    }
}

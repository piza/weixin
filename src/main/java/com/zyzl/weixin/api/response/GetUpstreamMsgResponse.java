package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.UpstreamMsg;

import java.util.List;

/**
 * @author peter
 */
public class GetUpstreamMsgResponse extends BaseResponse {

    private List<UpstreamMsg> list;

    public List<UpstreamMsg> getList() {
        return list;
    }

    public void setList(List<UpstreamMsg> list) {
        this.list = list;
    }
}

package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.InterfaceSummary;

import java.util.List;

/**
 * @author peter
 */
public class GetInterfaceSummaryResponse extends BaseResponse {

    private List<InterfaceSummary> list;

    public List<InterfaceSummary> getList() {
        return list;
    }

    public void setList(List<InterfaceSummary> list) {
        this.list = list;
    }
}

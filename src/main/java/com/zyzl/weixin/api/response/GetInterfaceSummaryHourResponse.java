package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.InterfaceSummaryHour;

import java.util.List;

/**
 * @author peter
 */
public class GetInterfaceSummaryHourResponse extends BaseResponse {

    private List<InterfaceSummaryHour> list;

    public List<InterfaceSummaryHour> getList() {
        return list;
    }

    public void setList(List<InterfaceSummaryHour> list) {
        this.list = list;
    }
}

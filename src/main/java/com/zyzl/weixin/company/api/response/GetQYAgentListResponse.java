package com.zyzl.weixin.company.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.company.api.entity.QYAgent;

import java.util.List;

/**
 *  
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class GetQYAgentListResponse extends BaseResponse {

    @JSONField(name = "agentlist")
    public List<QYAgent> agentList;

    public List<QYAgent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<QYAgent> agentList) {
        this.agentList = agentList;
    }
}

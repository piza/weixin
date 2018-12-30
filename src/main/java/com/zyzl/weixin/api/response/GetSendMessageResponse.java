package com.zyzl.weixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;


public class GetSendMessageResponse extends BaseResponse {

    @JSONField(name="msg_id")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}

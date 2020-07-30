package com.zyzl.weixin.mini.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyzl.weixin.api.response.BaseResponse;

/**
 * @Author: peter
 * @Date: 2020/7/30 09:42
 */
public class CodeToSessionResponse extends BaseResponse {

    private String openid;

    @JSONField(name = "session_key")
    private String sessionKey;

    private String unionid;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}

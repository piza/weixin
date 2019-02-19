package com.zyzl.weixin.api.config;

public class TokenData {

    private  String appid;
    private  String secret;
    private String accessToken;
    private String jsApiTicket;
    private boolean enableJsApi;
    private long jsTokenStartTime;
    private long weixinTokenStartTime;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getJsApiTicket() {
        return jsApiTicket;
    }

    public void setJsApiTicket(String jsApiTicket) {
        this.jsApiTicket = jsApiTicket;
    }

    public boolean isEnableJsApi() {
        return enableJsApi;
    }

    public void setEnableJsApi(boolean enableJsApi) {
        this.enableJsApi = enableJsApi;
    }

    public long getJsTokenStartTime() {
        return jsTokenStartTime;
    }

    public void setJsTokenStartTime(long jsTokenStartTime) {
        this.jsTokenStartTime = jsTokenStartTime;
    }

    public long getWeixinTokenStartTime() {
        return weixinTokenStartTime;
    }

    public void setWeixinTokenStartTime(long weixinTokenStartTime) {
        this.weixinTokenStartTime = weixinTokenStartTime;
    }
}

package com.zyzl.weixin.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PayConfig extends WXPayConfig{

    private byte[] certData;

    private String appId;
    private String mchID;
    private String certPath;
    private String key;

    public PayConfig(String appId,String mchID,String certPath,String key) {
        this.appId=appId;
        this.mchID=mchID;
        this.certPath=certPath;
        this.key=key;
        try {
            File file = new File(certPath);
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public byte[] getCertData() {
        return certData;
    }

    public void setCertData(byte[] certData) {
        this.certData = certData;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getAppID() {
        return this.appId;
    }

    @Override
    public String getMchID() {
        return this.mchID;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return WXPayDomainImpl.instance();
    }
}

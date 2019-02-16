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

    public String getAppID() {
        return this.appId;
    }

    public String getMchID() {
        return this.mchID;
    }


    public String getKey() {
        return this.key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return WXPayDomainImpl.instance();
    }
}

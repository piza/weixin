package com.zyzl.weixin.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class YslPayConfig extends WXPayConfig{

    private byte[] certData;

    public YslPayConfig() {
        try {
            String certPath = "/home/server/ysl/ysl-data/cert/apiclient_cert.p12";
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
        return "wx922bd7dfe74f7110";
    }

    public String getMchID() {
        return "1504533201";
    }

    public String getKey() {
        return "incncn87675cjdj2ijkaduvajjd8763c";
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

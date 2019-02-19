package com.zyzl.weixin.api.config;

import com.zyzl.weixin.handle.ApiConfigChangeHandle;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * API配置类，项目中请保证其为单例
 * 实现观察者模式，用于监控token变化
 *
 * @author peter
 * @since 1.2
 */
public interface ApiConfig extends Serializable {

    String getAppid();
    String getSecret();
    String getAccessToken();

    String getJsApiTicket();

    boolean isEnableJsApi();

    void setEnableJsApi(boolean enableJsApi);

    void addHandle(ApiConfigChangeHandle handle);

    /**
     * 移除配置变化监听器
     *
     * @param handle 监听器
     */
    void removeHandle(final ApiConfigChangeHandle handle);

    /**
     * 移除所有配置变化监听器
     */
    void removeAllHandle();


    long getWeixinTokenStartTime();

    long getJsTokenStartTime();

    AtomicBoolean getTokenRefreshing();
}

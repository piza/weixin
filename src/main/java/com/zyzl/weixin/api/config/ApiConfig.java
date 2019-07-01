package com.zyzl.weixin.api.config;

import java.io.Serializable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * API配置接口，项目中请保证其为单例
 * 实现观察者模式，用于监控token变化
 * 共有两个实现类，一个是单机版，一个是分布式版
 * 单机版把token保存在内存里面 ApiConfigMemory
 * 分布式版把token保存在数据库里面 ApiConfigDatabase
 * @author peter
 * @since 1.2
 */
public interface ApiConfig extends Serializable {

    void init();
    void checkExpired();
    String getAppid();
    String getSecret();
    String getAccessToken();

    String getJsApiTicket();

    boolean isEnableJsApi();

    void setEnableJsApi(boolean enableJsApi);

    void addHandle(Observer handle);

    /**
     * 移除配置变化监听器
     *
     * @param handle 监听器
     */
    void removeHandle(Observer handle);

    /**
     * 移除所有配置变化监听器
     */
    void removeAllHandle();


    long getWeixinTokenStartTime();

    long getJsTokenStartTime();

    AtomicBoolean getTokenRefreshing();

    TokenData getTokenData();
}

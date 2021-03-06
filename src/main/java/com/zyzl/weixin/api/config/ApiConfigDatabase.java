package com.zyzl.weixin.api.config;

import com.zyzl.weixin.api.response.GetJsApiTicketResponse;
import com.zyzl.weixin.api.response.GetTokenResponse;
import com.zyzl.weixin.exception.WeixinException;
import com.zyzl.weixin.util.JSONUtil;
import com.zyzl.weixin.util.NetWorkCenter;
import com.zyzl.weixin.util.StrUtil;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 用于分布式项目
 *  利用观察者模式，当token变化的时候，就通知观察者，观察者去保存到数据库中
 *  分布式系统每次都从数据库里面读取 TokenData， 如果没有或者过期，就更新token。
 * @author peter
 * @since 1.2
 */
public final class ApiConfigDatabase extends Observable implements ApiConfig {

    private static final Logger logger = LoggerFactory.getLogger(ApiConfigDatabase.class);
    private final AtomicBoolean tokenRefreshing = new AtomicBoolean(false);
    private final AtomicBoolean jsRefreshing = new AtomicBoolean(false);

    private TokenData tokenData;

    public ApiConfigDatabase (TokenData tokenData,Observer observer){
        this.tokenData=tokenData;
        super.addObserver(observer);
    }

    @Override
    public void init() {
        long now = System.currentTimeMillis();
        initToken(now);
        if (tokenData.isEnableJsApi()) initJSToken(now);
    }

    @Override
    public void checkExpired() {
        if(logger.isInfoEnabled()){
            logger.info("[getAccessToken]");
        }
        long now = System.currentTimeMillis();
        long time = now - this.tokenData.getWeixinTokenStartTime();
        try {
            /*
             * 判断优先顺序：
             * 1.官方给出的超时时间是7200秒，这里用7100秒来做，防止出现已经过期的情况
             * 2.刷新标识判断，如果已经在刷新了，则也直接跳过，避免多次重复刷新，如果没有在刷新，则开始刷新
             */

            if (time > 7100000 && this.tokenRefreshing.compareAndSet(false, true)) {
                if (logger.isWarnEnabled()) {
                    logger.warn("准备刷新token.............appId is "+tokenData.getAppid());
                }
                initToken(now);
            }
        } catch (Exception e) {
            logger.warn("刷新Token出错.", e);
            //刷新工作出现有异常，将标识设置回false
            this.tokenRefreshing.set(false);
        }

        if (tokenData.isEnableJsApi()) {
             now = System.currentTimeMillis();
            try {
                //官方给出的超时时间是7200秒，这里用7100秒来做，防止出现已经过期的情况
                if (now - this.tokenData.getJsTokenStartTime() > 7100000 && this.jsRefreshing.compareAndSet(false, true)) {
                    initJSToken(now);
                }
            } catch (Exception e) {
                logger.warn("刷新jsTicket出错.", e);
                //刷新工作出现有异常，将标识设置回false
                this.jsRefreshing.set(false);
            }
        }
    }

    public String getAppid() {
        return tokenData.getAppid();
    }

    public String getSecret() {
        return tokenData.getSecret();
    }

    public String getAccessToken() {
       return tokenData.getAccessToken();
    }

    public String getJsApiTicket() {
        return tokenData.getJsApiTicket();
    }

    public boolean isEnableJsApi() {
        return tokenData.isEnableJsApi();
    }

    public void setEnableJsApi(boolean enableJsApi) {
        this.tokenData.setEnableJsApi(enableJsApi);
    }

    /**
     * 添加配置变化监听器
     *
     * @param handle 监听器
     */
    public void addHandle(Observer handle) {
        super.addObserver(handle);
    }

    /**
     * 移除配置变化监听器
     *
     * @param handle 监听器
     */
    public void removeHandle(Observer handle) {
        super.deleteObserver(handle);
    }

    /**
     * 移除所有配置变化监听器
     */
    public void removeAllHandle() {
        super.deleteObservers();
    }

    /**
     * 初始化微信配置，即第一次获取access_token
     *
     * @param refreshTime 刷新时间
     */
    private void initToken(final long refreshTime) {
        if (logger.isInfoEnabled()) {
            logger.info("[initToken]");
        }
        //记住原本的时间，用于出错回滚
        final long oldTime = this.tokenData.getWeixinTokenStartTime();
        this.tokenData.setWeixinTokenStartTime(refreshTime);
        final String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + this.tokenData.getAppid() + "&secret=" + this.tokenData.getSecret();
        NetWorkCenter.get(url, null, new NetWorkCenter.ResponseCallback() {
            @Override
            public void onResponse(int resultCode, String resultJson) {
                if (HttpStatus.SC_OK == resultCode) {
                    GetTokenResponse response = JSONUtil.toBean(resultJson, GetTokenResponse.class);
                    if (logger.isInfoEnabled()) {
                        logger.info("[initToken] url is "+url);
                        logger.info("[access_token]:{}", response.getAccessToken());
                    }
                    if (null == response.getAccessToken()) {
                        //刷新时间回滚
                        tokenData.setWeixinTokenStartTime(oldTime);
                        String msg="[token exception] :" + response.getErrcode() + "," + response.getErrmsg();
                        throw new WeixinException(msg);
                    }
                    tokenData.setAccessToken(response.getAccessToken());
                    //设置通知点
                    setChanged();
                    notifyObservers(tokenData);
                }
            }
        });
        //刷新工作做完，将标识设置回false
        this.tokenRefreshing.set(false);
    }

    /**
     * 初始化微信JS-SDK，获取JS-SDK token
     *
     * @param refreshTime 刷新时间
     */
    private void initJSToken(final long refreshTime) {
        logger.debug("[initJSToken]");
        //记住原本的时间，用于出错回滚
        final long oldTime = this.tokenData.getJsTokenStartTime();
        this.tokenData.setJsTokenStartTime(refreshTime);
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + tokenData.getAccessToken() + "&type=jsapi";
        NetWorkCenter.get(url, null, new NetWorkCenter.ResponseCallback() {
            @Override
            public void onResponse(int resultCode, String resultJson) {
                if (HttpStatus.SC_OK == resultCode) {
                    GetJsApiTicketResponse response = JSONUtil.toBean(resultJson, GetJsApiTicketResponse.class);
                    logger.debug("[jsapi_ticket]:{}", response.getTicket());
                    if (StrUtil.isBlank(response.getTicket())) {
                        //刷新时间回滚
                        tokenData.setJsTokenStartTime(oldTime);
                        String msg="[jsToken exception]:" + response.getErrcode() + "," + response.getErrmsg();
//                        SysWeixinUtil.alertExcetpion(this,appid,secret,msg);
                        throw new WeixinException(msg);
                    }
                    tokenData.setJsApiTicket(response.getTicket());
                    //设置通知点
                    setChanged();
                    notifyObservers(tokenData);
                }
            }
        });
        //刷新工作做完，将标识设置回false
        this.jsRefreshing.set(false);
    }

    public long getWeixinTokenStartTime() {
        return tokenData.getWeixinTokenStartTime();
    }

    public long getJsTokenStartTime() {
        return tokenData.getJsTokenStartTime();
    }

    public AtomicBoolean getTokenRefreshing() {
        return tokenRefreshing;
    }

    @Override
    public TokenData getTokenData() {
        return this.tokenData;
    }
}

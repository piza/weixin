package com.zyzl.weixin.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zyzl.weixin.api.config.ApiConfig;
import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.util.CollectionUtil;
import com.zyzl.weixin.util.JSONUtil;
import com.zyzl.weixin.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统API
 *
 * @author peter
 */
public class SystemAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(com.zyzl.weixin.api.SystemAPI.class);

    public SystemAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 获取微信服务器IP地址列表
     *
     * @return IP地址列表
     */
    public List<String> getCallbackIP() {
        LOG.debug("获取微信服务器IP地址......");
        List<String> result = null;
        String url = BASE_API_URL + "cgi-bin/getcallbackip?access_token=#";
        BaseResponse r = executeGet(url);
        if (isSuccess(r.getErrcode())) {
            JSONArray array = JSON.parseObject(r.getErrmsg()).getJSONArray("ip_list");
            result = CollectionUtil.newArrayList(array.size());
            for (Object obj : array) result.add(obj.toString());
        }
        return result;
    }

    /**
     * 将一条长链接转成短链接
     *
     * @param longUrl 长链接
     * @return 对应的短链接
     */
    public String getShortUrl(String longUrl) {
        String result = "";
        LOG.debug("获取短URL.......");
        if (checkUrl(longUrl)) {
            String url = BASE_API_URL + "cgi-bin/shorturl?access_token=#";
            Map<String, String> params = new HashMap<String, String>();
            params.put("action", "long2short");
            params.put("long_url", longUrl);
            BaseResponse r = executePost(url, JSONUtil.toJson(params));
            if (isSuccess(r.getErrcode())) {
                result = JSONUtil.toMap(r.getErrmsg()).get("short_url").toString();
            }
        }
        return result;
    }

    /**
     * 检查URL是否支持
     *
     * @param url 需要检查的URL
     * @return 是否支持
     */
    private boolean checkUrl(String url) {
        return StrUtil.isNotBlank(url) && (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("weixin://wxpay"));
    }
}

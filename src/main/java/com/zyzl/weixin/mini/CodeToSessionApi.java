package com.zyzl.weixin.mini;

import com.zyzl.weixin.api.BaseAPI;
import com.zyzl.weixin.api.config.ApiConfig;
import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.mini.response.CodeToSessionResponse;
import com.zyzl.weixin.util.JSONUtil;
import com.zyzl.weixin.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: peter
 * @Date: 2020/7/30 09:39
 * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
 */
public class CodeToSessionApi extends BaseAPI{

    private static final Logger logger = LoggerFactory.getLogger(CodeToSessionApi.class);


    public CodeToSessionApi(ApiConfig config) {
        super(config);
    }

    public CodeToSessionResponse codeToSession(String code){
        if(StrUtil.isBlank(code)){
            return null;
        }
        logger.info("codeToSession:"+code);
        CodeToSessionResponse response;
        String url=BASE_API_URL+"sns/jscode2session?appid="+config.getAppid()+"&secret="+config.getSecret()+"&js_code="+code+"&grant_type=authorization_code";

        logger.debug("url: "+url);
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, CodeToSessionResponse.class);
        return response;

    }
}

package com.zyzl.weixin.api;

import com.zyzl.weixin.api.config.ApiConfig;
import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.bean.WechatCommonResponse;
import com.zyzl.weixin.util.JSONUtil;
import com.zyzl.weixin.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 通用API，懒得一个一个开发了
 * @author wenbin
 *
 */
public class CommonAPI extends BaseAPI {

    private static final Logger logger = LoggerFactory.getLogger(CommonAPI.class);

    public CommonAPI(ApiConfig config) {
        super(config);
    }

    //apiPath like "cgi-bin/user/get?access_token=#"
    public WechatCommonResponse getApi(String apiPath) {
        if(StrUtil.isBlank(apiPath)){
            return null;
        }
        logger.info("common get ....."+apiPath);
        String url = BASE_API_URL + apiPath;
        return formatResult(executeGet(url));
    }

    private WechatCommonResponse formatResult(BaseResponse r ){
        WechatCommonResponse response;
        if(isSuccess(r.getErrcode())){
            response=new WechatCommonResponse();
            response.setErrcode("0");
            response.setJsonResult(r.getErrmsg());
        }else{
            response = JSONUtil.toBean(r.toJsonString(), WechatCommonResponse.class);
        }
        return response;
    }


    public WechatCommonResponse postApi(String apiPath,String postJson) {
        if(StrUtil.isBlank(apiPath)){
            return null;
        }
        logger.info("common post....."+apiPath);
        String url = BASE_API_URL + apiPath;
        return formatResult(executePost(url, postJson));
    }


    public WechatCommonResponse postWithFileApi(String apiPath,String postJson,File file) {
        if(StrUtil.isBlank(apiPath)){
            return null;
        }
        logger.info("common post with file....."+apiPath);
        String url = BASE_API_URL + apiPath;
        return formatResult(executePost(url, postJson,file));
    }
}
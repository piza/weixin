package com.zyzl.weixin.api;

import com.zyzl.weixin.api.config.ApiConfig;
import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.api.response.CreateCardResponse;
import com.zyzl.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 二维码相关API
 *
 * @author peter
 * @since 1.2
 */
public class CardAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(CardAPI.class);

    public CardAPI(ApiConfig config) {
        super(config);
    }




    public CreateCardResponse createCard() {

        CreateCardResponse response;
        String url = BASE_API_URL +"card/create?access_token=#";

        Map<String, Object> param = new HashMap<String, Object>();

        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, CreateCardResponse.class);

        return response;
    }
}

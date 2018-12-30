package com.zyzl.weixin.api;

import com.zyzl.weixin.api.config.ApiConfig;
import com.zyzl.weixin.api.enums.ResultType;
import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.api.response.CreateTagResponse;
import com.zyzl.weixin.api.response.GetAllTagsResponse;
import com.zyzl.weixin.api.response.GetUsersResponse;
import com.zyzl.weixin.util.BeanUtil;
import com.zyzl.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 标签相关API
 * @author peter
 * @since 1.3.9
 */
public class TagAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(com.zyzl.weixin.api.TagAPI.class);

    /**
     * 构造方法，设置apiConfig
     *
     * @param config 微信API配置对象
     */
    public TagAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 创建标签
     * @param tagName 标签名称
     * @return 创建的标签结果
     */
    public CreateTagResponse create(String tagName) {
        BeanUtil.requireNonNull(tagName, "tagName is null");
        CreateTagResponse response;
        LOG.debug("创建标签.....");
        String url = BASE_API_URL + "cgi-bin/tags/create?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("name", tagName);
        param.put("tag", tag);
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, CreateTagResponse.class);
        return response;
    }

    /**
     * 获取已经创建的标签
     * @return 已经创建的标签列表
     */
    public GetAllTagsResponse getAllTags() {
        GetAllTagsResponse response;
        LOG.debug("获取已经创建的标签.....");
        String url = BASE_API_URL + "cgi-bin/tags/get?access_token=#";
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetAllTagsResponse.class);
        return response;
    }

    /**
     * 编辑标签
     * @param tagId 标签ID
     * @param newTagName 新的标签名称
     * @return 编辑结果
     */
    public ResultType updateTag(Integer tagId, String newTagName) {
        BeanUtil.requireNonNull(tagId, "tagId is null");
        BeanUtil.requireNonNull(newTagName, "newTagName is null");
        LOG.debug("编辑标签.....");
        String url = BASE_API_URL + "cgi-bin/tags/update?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", tagId);
        param.put("name", newTagName);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 删除标签
     * @param tagId 需要删除的标签ID
     * @return 删除结果
     */
    public ResultType deleteTag(Integer tagId) {
        BeanUtil.requireNonNull(tagId, "tagId is null");
        LOG.debug("删除标签.....");
        String url = BASE_API_URL + "cgi-bin/tags/delete?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", tagId);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取标签下粉丝
     * @param tagId 标签ID
     * @param nextOpenid 下一个用户的openid,第一次不用填
     * @return 本批用户列表
     */
    public GetUsersResponse getUsersByTagId(Integer tagId, String nextOpenid) {
        BeanUtil.requireNonNull(tagId, "tagId is null");
        GetUsersResponse response;
        LOG.debug("开始获取标签下粉丝.....");
        String url = BASE_API_URL + "cgi-bin/user/tag/get?access_token=#";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tagid", tagId);
        param.put("next_openid", null == nextOpenid ? "" : nextOpenid);
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetUsersResponse.class);
        return response;
    }
}

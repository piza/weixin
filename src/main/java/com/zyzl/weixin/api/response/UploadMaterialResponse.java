package com.zyzl.weixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;


public class UploadMaterialResponse extends BaseResponse {

    @JSONField(name = "media_id")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

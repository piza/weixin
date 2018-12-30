package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.Tag;

/**
 * @author peter
 * @since 1.3.9
 */
public class CreateTagResponse extends BaseResponse {

    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

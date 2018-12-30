package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.Tag;

import java.util.List;

/**
 * @author peter
 * @since 1.3.9
 */
public class GetAllTagsResponse extends BaseResponse {

    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

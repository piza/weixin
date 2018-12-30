package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.ArticleTotal;

import java.util.List;

/**
 * @author peter
 */
public class GetArticleTotalResponse extends BaseResponse {

    private List<ArticleTotal> list;

    public List<ArticleTotal> getList() {
        return list;
    }

    public void setList(List<ArticleTotal> list) {
        this.list = list;
    }
}

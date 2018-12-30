package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.ArticleSummary;

import java.util.List;

/**
 * @author peter
 */
public class GetArticleSummaryResponse extends BaseResponse {

    private List<ArticleSummary> list;

    public List<ArticleSummary> getList() {
        return list;
    }

    public void setList(List<ArticleSummary> list) {
        this.list = list;
    }
}

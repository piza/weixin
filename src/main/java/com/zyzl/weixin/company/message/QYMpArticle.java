package com.zyzl.weixin.company.message;

import com.zyzl.weixin.api.entity.Article;


public class QYMpArticle extends Article {

    public QYMpArticle(String thumbMediaId, String author, String title, String contentSourceUrl, String content, String digest, Integer showConverPic) {
        super(thumbMediaId, author, title, contentSourceUrl, content, digest, showConverPic);
    }

}

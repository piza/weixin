package com.zyzl.weixin.company.message;/**
 * Created by Nottyjay on 2015/6/12.
 */

import com.alibaba.fastjson.annotation.JSONField;


public class QYTextMsg extends QYBaseMsg {

    @JSONField(name = "text")
    private Text text;

    public QYTextMsg() {
        this.setMsgType("text");
    }

    public QYTextMsg(String content) {
        this.text = new Text(content);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setConetnt(String content){
        this.text = new Text(content);
    }

    public static class Text{
        @JSONField(name = "content")
        private String content;

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}

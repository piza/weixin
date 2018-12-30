package com.zyzl.weixin.message;

import com.zyzl.weixin.message.util.MessageBuilder;

public final class TextMsg extends BaseMsg {

    private StringBuilder contentBuilder;

    public TextMsg() {
        contentBuilder = new StringBuilder();
    }

    public TextMsg(String content) {
        setContent(content);
    }

    public String getContent() {
        return contentBuilder.toString();
    }

    public void setContent(String content) {
        contentBuilder = new StringBuilder(content);
    }

    public com.zyzl.weixin.message.TextMsg add(String text) {
        contentBuilder.append(text);
        return this;
    }

    public com.zyzl.weixin.message.TextMsg addln() {
        return add("\n");
    }

    public com.zyzl.weixin.message.TextMsg addln(String text) {
        contentBuilder.append(text);
        return addln();
    }

    public com.zyzl.weixin.message.TextMsg addLink(String text, String url) {
        contentBuilder.append("<a href=\"").append(url).append("\">")
                .append(text).append("</a>");
        return this;
    }

    @Override
    public String toXml() {
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("Content", contentBuilder.toString().trim());
        mb.addData("MsgType", RespType.TEXT);
        mb.surroundWith("xml");
        return mb.toString();
    }

}

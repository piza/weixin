package com.zyzl.weixin.company.message.resp;

import com.zyzl.weixin.message.RespType;
import com.zyzl.weixin.message.util.MessageBuilder;


public class QYVideoRespMsg extends QYBaseRespMsg {
    private String mediaId;
    private String title;
    private String description;

    public QYVideoRespMsg() {
    }

    public QYVideoRespMsg(String mediaId, String title, String description) {
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toXml() {
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("MsgType", RespType.VIDEO);
        mb.append("<Video>\n");
        mb.addData("MediaId", mediaId);
        mb.addData("Title", title);
        mb.addData("Description", description);
        mb.append("</Video>\n");
        mb.surroundWith("xml");
        return mb.toString();
    }
}

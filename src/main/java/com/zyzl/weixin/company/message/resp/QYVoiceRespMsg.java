package com.zyzl.weixin.company.message.resp;

import com.zyzl.weixin.message.RespType;
import com.zyzl.weixin.message.util.MessageBuilder;


public class QYVoiceRespMsg extends QYBaseRespMsg {

    private String mediaId;

    public QYVoiceRespMsg() {
    }

    public QYVoiceRespMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toXml(){
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("MsgType", RespType.VOICE);
        mb.append("<Voice>\n");
        mb.addData("MediaId", mediaId);
        mb.append("</Voice>\n");
        mb.surroundWith("xml");
        return mb.toString();
    }
}

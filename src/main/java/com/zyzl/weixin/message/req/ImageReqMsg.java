package com.zyzl.weixin.message.req;

/**
 * @author peter
 */
public final class ImageReqMsg extends BaseReqMsg {

    private String picUrl;
    private String mediaId;

    public ImageReqMsg(String picUrl, String mediaId) {
        super();
        this.picUrl = picUrl;
        this.mediaId = mediaId;
        setMsgType(ReqType.IMAGE);
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    @Override
    public String toString() {
        return "ImageReqMsg [picUrl=" + picUrl + ", mediaId=" + mediaId
                + ", toUserName=" + toUserName + ", fromUserName="
                + fromUserName + ", createTime=" + createTime + ", msgType="
                + msgType + ", msgId=" + msgId + "]";
    }

}

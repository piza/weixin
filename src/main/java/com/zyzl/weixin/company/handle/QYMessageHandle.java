package com.zyzl.weixin.company.handle;

import com.zyzl.weixin.company.message.req.QYBaseReqMsg;
import com.zyzl.weixin.company.message.resp.QYBaseRespMsg;

public interface QYMessageHandle<M extends QYBaseReqMsg> {
    /**
     * 处理微信消息
     *
     * @param message 微信消息
     * @return 回复用户的消息
     */
    QYBaseRespMsg handle(M message);

    /**
     * 在处理之前，判断本条消息是否符合处理的条件
     *
     * @param message 消息
     * @return 是否需要处理
     */
    boolean beforeHandle(M message);
}

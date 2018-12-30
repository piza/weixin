package com.zyzl.weixin.company.handle;

import com.zyzl.weixin.company.message.req.QYBaseEvent;
import com.zyzl.weixin.company.message.resp.QYBaseRespMsg;


public interface QYEventHandle<E extends QYBaseEvent>{

    /**
     * 处理微信事件
     *
     * @param event 微信事件
     * @return 回复用户的消息
     */
    QYBaseRespMsg handle(E event);

    /**
     * 在处理之前，判断本事件是否符合处理的条件
     *
     * @param event 事件
     * @return 是否需要处理
     */
    boolean beforeHandle(E event);
}

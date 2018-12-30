package com.zyzl.weixin.api.entity;

import com.zyzl.weixin.util.JSONUtil;

/**
 * 抽象实体类
 *
 * @author peter
 */
public abstract class BaseModel implements Model {
    @Override
    public String toJsonString() {
        return JSONUtil.toJson(this);
    }
}

package com.zyzl.weixin.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 累计用户数据
 *
 * @author peter
 */
public class UserCumulate extends BaseDataCube {

    @JSONField(name = "cumulate_user")
    private Integer cumulateUser;

    public Integer getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(Integer cumulateUser) {
        this.cumulateUser = cumulateUser;
    }
}

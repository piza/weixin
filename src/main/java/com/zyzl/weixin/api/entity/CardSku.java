package com.zyzl.weixin.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class CardSku extends BaseModel{
    /**
     * 卡券库存的数量,不支持填写0，上限为100000000。
     */
        @JSONField(name = "quantity")
    private Integer quantity = 100000000;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

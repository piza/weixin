package com.zyzl.weixin.enums;

public enum WechatMenuConditionalEnum {
    DEFAULT((byte)0),
    CONDITIONAL((byte)1);// 必须有默认菜单才可以有个性菜单

    private Byte value;

    WechatMenuConditionalEnum(Byte value) {
        this.value=value;
    }

    public Byte getValue(){
        return this.value.byteValue();
    }
}

package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.BaseModel;
import com.zyzl.weixin.api.enums.ResultType;
import com.zyzl.weixin.util.BeanUtil;
import com.zyzl.weixin.util.StrUtil;

/**
 * 微信API响应报文对象基类
 *
 * @author peter
 */
public class BaseResponse extends BaseModel {

    private String errcode;
    private String errmsg;// 代表微信返回的成功数据,这个sb命名，具体逻辑查看NetWorkCenter中的逻辑。

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        String result = this.errmsg;
        //将接口返回的错误信息转换成中文，方便提示用户出错原因
        if (StrUtil.isNotBlank(this.errcode) && !ResultType.SUCCESS.getCode().toString().equals(this.errcode)) {
            ResultType resultType = ResultType.get(this.errcode);
            if(BeanUtil.nonNull(resultType)) {
                result = resultType.getDescription();
            }
        }
        return result;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

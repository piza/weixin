package com.zyzl.weixin.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class CardDateInfo extends BaseModel{


    /**
     * 使用时间的类型,支持固定时长有效类型 固定日期有效类型 永久有效类型：DATE_TYPE_FIX_TERM_RANGE、DATE_TYPE_FIX_TERM 、DATE_TYPE_PERMANENT
     */
        @JSONField(name = "type")
    private String type = "DATE_TYPE_PERMANENT";

    /**
     * 起用时间,type为DATE_TYPE_FIX_TIME_RANGE时专用， 表示起用时间。从1970年1月1日00:00:00至起用时间的秒数 （ 东八区时间,UTC+8，单位为秒 ）
     */
        @JSONField(name = "begin_timestamp")
    private Long beginTimestamp;

    /**
     * 结束时间,type为DATE_TYPE_FIX_TERM_RANGE时专用，表示结束时间 （ 东八区时间,UTC+8，单位为秒 ）
     */
        @JSONField(name = "end_timestamp")
    private Long endTimestamp;

    /**
     * 自领取后多少天内有效,type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，领取后当天有效填写0（单位为天）
     */
        @JSONField(name = "fixed_term")
    private Integer fixedTerm;

    /**
     * 自领取后多少天开始生效,type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效。（单位为天）
     */
        @JSONField(name = "fixed_begin_term")
    private Integer fixedBeginTerm;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBeginTimestamp() {
        return beginTimestamp;
    }

    public void setBeginTimestamp(Long beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public Integer getFixedTerm() {
        return fixedTerm;
    }

    public void setFixedTerm(Integer fixedTerm) {
        this.fixedTerm = fixedTerm;
    }

    public Integer getFixedBeginTerm() {
        return fixedBeginTerm;
    }

    public void setFixedBeginTerm(Integer fixedBeginTerm) {
        this.fixedBeginTerm = fixedBeginTerm;
    }
}

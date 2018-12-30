package com.zyzl.weixin.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class CardBaseInfo extends BaseModel{


    /**
     * 卡券的商户logo,建议像素为300*300。
     */
        @JSONField(name = "logo_url")
    private String logoUrl;

    /**
     * Code展示类型,"CODE_TYPE_TEXT" 文本 "CODE_TYPE_BARCODE" 一维码 "CODE_TYPE_QRCODE" 二维码 "CODE_TYPE_ONLY_QRCODE" 仅显示二维码 "CODE_TYPE_ONLY_BARCODE" 仅显示一维码 "CODE_TYPE_NONE" 不显示任何码型
     */
        @JSONField(name = "code_type")
    private String codeType = "CODE_TYPE_QRCODE";

    /**
     * 支付功能结构体,swipe_card结构
     */
//        @JSONField(name = "pay_info")
//    private PayInfo payInfo;

    /**
     * 是否设置该会员卡中部的按钮同时支持微信支付刷卡和会员卡二维码
     */
        @JSONField(name = "is_pay_and_qrcode")
    private boolean isPayAndQrcode;

    /**
     * 商户名字,字数上限为12个汉字
     */
        @JSONField(name = "brand_name")
    private String brandName;

    /**
     * 卡券名,字数上限为9个汉字 (建议涵盖卡券属性、服务及金额)。
     */
        @JSONField(name = "title")
    private String title;

    /**
     * 券颜色,按色彩规范标注填写Color010-Color100
     */
        @JSONField(name = "color")
    private String color;

    /**
     * 卡券使用提醒,字数上限为16个汉字
     */
        @JSONField(name = "notice")
    private String notice;

    /**
     * 卡券使用说明,字数上限为1024个汉字。
     */
        @JSONField(name = "description")
    private String description;

    /**
     * 商品信息
     */
        @JSONField(name = "sku")
    private CardSku sku;

    /**
     * 使用日期,有效期的信息。
     */
        @JSONField(name = "date_info")
    private CardDateInfo dateInfo;

    /**
     * 是否自定义Code码,填写true或false，默认为false 通常自有优惠码系统的开发者选择自定义Code码，详情见 是否自定义code
     */
        @JSONField(name = "use_custom_code")
    private boolean useCustomCode;

    /**
     * 是否指定用户领取,填写true或false。默认为false
     */
        @JSONField(name = "bind_openid")
    private boolean bindOpenid;

    /**
     * 客服电话
     */
        @JSONField(name = "service_phone")
    private String servicePhone;

    /**
     * 门店位置ID,调用 POI门店管理接口 获取门店位置ID。
     */
        @JSONField(name = "location_id_list")
    private String locationIdList;

    /**
     * 会员卡是否支持全部门店,填写后商户门店更新时会自动同步至卡券
     */
        @JSONField(name = "use_all_locations")
    private boolean useAllLocations = true;

    /**
     * 卡券中部居中的按钮,仅在卡券激活后且可用状态 时显示
     */
        @JSONField(name = "center_title")
    private String centerTitle;

    /**
     * 显示在入口下方的提示语,仅在卡券激活后且可用状态时显示
     */
        @JSONField(name = "center_sub_title")
    private String centerSubTitle;

    /**
     * 顶部居中的url,仅在卡券激活后且可用状态时显示
     */
        @JSONField(name = "center_url")
    private String centerUrl;

    /**
     * 自定义跳转外链的入口名字
     */
        @JSONField(name = "custom_url_name")
    private String customUrlName;

    /**
     * 自定义跳转的URL
     */
        @JSONField(name = "custom_url")
    private String customUrl;

    /**
     * 显示在入口右侧的提示语
     */
        @JSONField(name = "custom_url_sub_title")
    private String customUrlSubTitle;

    /**
     * 营销场景的自定义入口名称
     */
        @JSONField(name = "promotion_url_name")
    private String promotionUrlName;

    /**
     * 入口跳转外链的地址链接
     */
        @JSONField(name = "promotion_url")
    private String promotionUrl;

    /**
     * 显示在营销入口右侧的提示语
     */
        @JSONField(name = "promotion_url_sub_title")
    private String promotionUrlSubTitle;

    /**
     * 每人可领券的数量限制,建议会员卡每人限领一张
     */
        @JSONField(name = "get_limit")
    private Integer getLimit = 1;

    /**
     * 卡券领取页面是否可分享,默认为true
     */
        @JSONField(name = "can_share")
    private boolean canShare;

    /**
     * 卡券是否可转赠,默认为true
     */
        @JSONField(name = "can_give_friend")
    private boolean canGiveFriend;

    /**
     * 用户点击进入会员卡时推送事件,填写true为用户点击进入会员卡时推送事件，默认为false。详情见 进入会员卡事件推送
     */
        @JSONField(name = "need_push_on_view")
    private boolean needPushOnView;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public boolean isPayAndQrcode() {
        return isPayAndQrcode;
    }

    public void setPayAndQrcode(boolean payAndQrcode) {
        isPayAndQrcode = payAndQrcode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardSku getSku() {
        return sku;
    }

    public void setSku(CardSku sku) {
        this.sku = sku;
    }

    public CardDateInfo getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(CardDateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }

    public boolean isUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public boolean isBindOpenid() {
        return bindOpenid;
    }

    public void setBindOpenid(boolean bindOpenid) {
        this.bindOpenid = bindOpenid;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public String getLocationIdList() {
        return locationIdList;
    }

    public void setLocationIdList(String locationIdList) {
        this.locationIdList = locationIdList;
    }

    public boolean isUseAllLocations() {
        return useAllLocations;
    }

    public void setUseAllLocations(boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
    }

    public String getCenterTitle() {
        return centerTitle;
    }

    public void setCenterTitle(String centerTitle) {
        this.centerTitle = centerTitle;
    }

    public String getCenterSubTitle() {
        return centerSubTitle;
    }

    public void setCenterSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl;
    }

    public String getCustomUrlName() {
        return customUrlName;
    }

    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }

    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }

    public String getPromotionUrlName() {
        return promotionUrlName;
    }

    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }

    public String getPromotionUrl() {
        return promotionUrl;
    }

    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    public String getPromotionUrlSubTitle() {
        return promotionUrlSubTitle;
    }

    public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
    }

    public Integer getGetLimit() {
        return getLimit;
    }

    public void setGetLimit(Integer getLimit) {
        this.getLimit = getLimit;
    }

    public boolean isCanShare() {
        return canShare;
    }

    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    public boolean isCanGiveFriend() {
        return canGiveFriend;
    }

    public void setCanGiveFriend(boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
    }

    public boolean isNeedPushOnView() {
        return needPushOnView;
    }

    public void setNeedPushOnView(boolean needPushOnView) {
        this.needPushOnView = needPushOnView;
    }
}

package com.zyzl.weixin.api.entity;

public class Card extends BaseModel{



    private String cardId;

    private Long beginTime;

    private Long endTime;

    private String userCardStatus;

    private Boolean canConsume;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getUserCardStatus() {
        return userCardStatus;
    }

    public void setUserCardStatus(String userCardStatus) {
        this.userCardStatus = userCardStatus;
    }

    public Boolean getCanConsume() {
        return canConsume;
    }

    public void setCanConsume(Boolean canConsume) {
        this.canConsume = canConsume;
    }
}

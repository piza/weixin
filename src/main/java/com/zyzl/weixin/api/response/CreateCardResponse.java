package com.zyzl.weixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author peter
 */
public class CreateCardResponse extends BaseResponse {

	@JSONField(name = "card_id")
	private String cardId;


	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}

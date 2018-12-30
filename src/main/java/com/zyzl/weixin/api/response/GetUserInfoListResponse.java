package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.response.GetUserInfoResponse;

import java.util.List;

/**
 * @author Nottyjay
 */
public class GetUserInfoListResponse extends BaseResponse {
    private List<com.zyzl.weixin.api.response.GetUserInfoResponse> user_info_list;

    public List<com.zyzl.weixin.api.response.GetUserInfoResponse> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<GetUserInfoResponse> user_info_list) {
        this.user_info_list = user_info_list;
    }
}

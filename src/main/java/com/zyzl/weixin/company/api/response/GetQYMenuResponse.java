package com.zyzl.weixin.company.api.response;

import com.zyzl.weixin.api.response.BaseResponse;
import com.zyzl.weixin.company.api.entity.QYMenu;

/**
 *  Response -- 获取菜单
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class GetQYMenuResponse extends BaseResponse {

    private QYMenu menu;

    public QYMenu getMenu() {
        return menu;
    }

    public void setMenu(QYMenu menu) {
        this.menu = menu;
    }
}

package com.zyzl.weixin.api.response;

import com.zyzl.weixin.api.entity.Menu;

/**
 * @author peter
 */
public class GetMenuResponse extends BaseResponse {

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

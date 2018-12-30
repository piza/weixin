package com.zyzl.weixin.message.req;

public final class EventType {

    public static final String SUBSCRIBE       = "subscribe";
    public static final String UNSUBSCRIBE     = "unsubscribe";
    public static final String CLICK           = "CLICK";
    public static final String VIEW            = "VIEW";
    public static final String LOCATION        = "LOCATION";
    public static final String SCAN            = "SCAN";
    public static final String SCANCODEPUSH    = "scancode_push";
    public static final String SCANCODEWAITMSG = "scancode_waitmsg";
    public static final String PICSYSPHOTO     = "pic_sysphoto";
    public static final String PICPHOTOORALBUM = "pic_photo_or_album";
    public static final String PICWEIXIN       = "pic_weixin";
    public static final String LOCATIONSELECT  = "location_select";
    public static final String TEMPLATESENDJOBFINISH  = "TEMPLATESENDJOBFINISH";
    public static final String MASSSENDJOBFINISH="MASSSENDJOBFINISH";


    public static final String USER_GET_CARD="user_get_card";
    public static final String USER_GIFTING_CARD="user_gifting_card";
    public static final String USER_DEL_CARD="user_del_card";
    public static final String USER_CONSUME_CARD="user_consume_card";
    public static final String USER_PAY_FROM_PAY_CELL="user_pay_from_pay_cell";


    private EventType() {
    }

}

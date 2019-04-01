package com.zyzl.weixin.util;

public class ThreadQrcodeUtil {

    private static ThreadLocal<Object>  localQrcode=new ThreadLocal<>();

    private ThreadQrcodeUtil(){

    }

    public static <T> T getQrcode(Class<T> tClass){
        Object obj= localQrcode.get();
        if(obj==null){
            return null;
        }
        return (T)obj;
    }

    public static void remove(){
        localQrcode.remove();
    }

    public static void setQrcode(Object object){
        localQrcode.set(object);
    }
}

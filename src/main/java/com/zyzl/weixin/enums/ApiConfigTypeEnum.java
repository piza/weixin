package com.zyzl.weixin.enums;

/**
 * Created by Peter on 19/9/28.
 */
public enum ApiConfigTypeEnum {

    CLOUD("cloud"),
    MEMORY("memory"),
    DATABASE("database");

    private String value;

    ApiConfigTypeEnum(String value) {
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }

    public static ApiConfigTypeEnum convert(String type){
        if (type == null) {
            return null;
        }
        switch (type) {
            case "cloud": return CLOUD;
            case "memory": return MEMORY;
            case "database": return DATABASE;
            default:return null;
        }
    }

}

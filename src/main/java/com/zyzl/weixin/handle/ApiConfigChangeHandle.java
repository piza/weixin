package com.zyzl.weixin.handle;

import java.util.Observer;

/**
 * ApiConfig变化监听器，基于jdk自带观察者模式实现
 *
 * @author Nottyjay, peter
 * @see AbstractApiConfigChangeHandle
 */
public interface ApiConfigChangeHandle extends Observer {

}

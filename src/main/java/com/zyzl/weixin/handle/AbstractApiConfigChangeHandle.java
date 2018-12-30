package com.zyzl.weixin.handle;

import com.zyzl.weixin.api.config.ConfigChangeNotice;
import com.zyzl.weixin.util.BeanUtil;

import java.util.Observable;

/**
 * 配置变化监听器抽象类
 *
 * @author peter
 */
public abstract class AbstractApiConfigChangeHandle implements ApiConfigChangeHandle {

    @Override
    public void update(Observable o, Object arg) {
        if (BeanUtil.nonNull(arg) && arg instanceof ConfigChangeNotice) {
            configChange((ConfigChangeNotice) arg);
        }
    }

    /**
     * 子类实现，当配置变化时会触发该方法
     *
     * @param notice 通知对象
     */
    public abstract void configChange(ConfigChangeNotice notice);
}

package com.yj.xiuxian.panel;

import java.lang.reflect.Type;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/8/31 13:06
 */
public interface GenericManage<T> {

    //    注册当前实例到管理介质当中
    void register();

//    通过key到特定的选择栏区选择特定的东西
    T getInstanceByKey(String key, Class<T> clazz);

}

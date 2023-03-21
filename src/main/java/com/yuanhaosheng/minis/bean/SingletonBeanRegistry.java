package com.yuanhaosheng.minis.bean;

/**
 * @Description: TODO
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public interface SingletonBeanRegistry {

    /**
     * 注册
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取
     * @param beanName
     * @return
     */
    Object getSingletonBean(String beanName);

    /**
     * 是否包含
     * @param beanName
     * @return
     */
    boolean containsSingletonBean(String beanName);

    /**
     * 获取所有beanNames
     * @return
     */
    String[] getSingletonNames();
}

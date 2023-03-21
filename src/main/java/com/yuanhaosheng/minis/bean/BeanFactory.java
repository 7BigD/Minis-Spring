package com.yuanhaosheng.minis.bean;

/**
 * @Description: TODO
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeanException;

    Boolean containsBean(String beanName);

    void registerBean(String beanName, Object obj);
}

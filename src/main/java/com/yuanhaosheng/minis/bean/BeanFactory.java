package com.yuanhaosheng.minis.bean;

/**
 * @Description: TODO
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public interface BeanFactory {

    Object getBean(String beanId) throws BeanException;

    void registerBeanDefinition(BeanDefinition beanDefinition);

}

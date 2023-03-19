package com.yuanhaosheng.minis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public class SimpleBeanFactory implements BeanFactory {

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private List<String> beanNames = new ArrayList<>();
    private Map<String, Object> singletons = new HashMap<>();

    public SimpleBeanFactory() {
    }

    //getBean，容器的核心方法
    @Override
    public Object getBean(String beanId) throws BeanException{
        Object singleton = singletons.get(beanId);
        if (singleton != null) {
            return singleton;
        } else {
            int i = beanNames.indexOf(beanId);
            if (i == -1) {
                throw new BeanException("beanId not exist... ");
            } else {
                BeanDefinition beanDefinition = beanDefinitions.get(i);
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                    singletons.put(beanDefinition.getId(), singleton);
                } catch (InstantiationException e) {
                } catch (IllegalAccessException e) {
                } catch (ClassNotFoundException e) {
                }
            }
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
        this.beanNames.add(beanDefinition.getId());
    }
}

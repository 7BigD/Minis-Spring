package com.yuanhaosheng.minis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256); // yhs: 这个地方的作用是 充当"加一层"。

    public SimpleBeanFactory() {
    }

    //getBean，容器的核心方法
    @Override
    public Object getBean(String beanName) throws BeanException{
        Object singleton = singletons.get(beanName);
        if (singleton == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition == null) {
                throw new BeanException("No bean. ");
            }
            try {
                singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                this.registerSingleton(beanName, singleton);
//                singletons.put(beanDefinition.getId(), singleton);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return singleton;
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanDefinition.getId(), beanDefinition);
    }

    public Boolean containsBean(String beanName) {
        return this.beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public void registerBean(String bean, Object obj) {
        this.registerSingleton(bean, obj);
    }
}

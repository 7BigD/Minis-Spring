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
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    // Bean容器中存放所有bean的名称的列表
    protected List<String> beanNames = new ArrayList<>();

    // bean容器存放所有 bean 实例的map
    protected Map<String, Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        synchronized (this) {
            this.singletons.put(beanName, singletonObject);
            this.beanNames.add(beanName);
        }
    }

    @Override
    public Object getSingletonBean(String beanName) {
        return this.singletons.get(beanName);
    }

    @Override
    public boolean containsSingletonBean(String beanName) {
        return singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[]) this.beanNames.toArray();
    }

    protected void removeSingletonBean(String beanName) {
        synchronized (this) {
            this.singletons.remove(beanName);
            this.beanNames.remove(beanName);
        }
    }
}

package com.yuanhaosheng.minis.context;

import com.yuanhaosheng.minis.bean.*;
import com.yuanhaosheng.minis.core.ClassPathXmlResource;
import com.yuanhaosheng.minis.core.Resource;

/**
 * 1. 解析 XML 文件中的内容。加载解析的内容，构建 BeanDefinition。
 * 2. 读取 BeanDefinition 的配置信息，
 * 3. 实例化 Bean，然后把它注入到 BeanFactory 容器中。
 */

public class ClassPathXmlApplicationContext {

    private SimpleBeanFactory simpleBeanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory factory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        this.simpleBeanFactory = factory;
    }

    public Object getBean(String beanId) throws BeanException {
        return this.simpleBeanFactory.getBean(beanId);
    }

    public Boolean containsBean(String name) {
        return this.simpleBeanFactory.containsBean(name);
    }

    public void registerBean(String beanName, Object obj) {
        this.simpleBeanFactory.registerBean(beanName, obj);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.simpleBeanFactory.registerBeanDefinition(beanDefinition);
    }
}

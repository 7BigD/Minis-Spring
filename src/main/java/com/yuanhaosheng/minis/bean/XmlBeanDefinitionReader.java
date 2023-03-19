package com.yuanhaosheng.minis.bean;

import com.yuanhaosheng.minis.core.Resource;
import org.dom4j.Element;

/**
 * @Description: 将resource 加载进 BeanFactory
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public class XmlBeanDefinitionReader {

    private BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            beanFactory.registerBeanDefinition(beanDefinition);
        }
    }


}

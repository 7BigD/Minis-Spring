package com.yuanhaosheng.minis.test;

import com.yuanhaosheng.minis.bean.BeanException;
import com.yuanhaosheng.minis.context.ClassPathXmlApplicationContext;

/**
 * @Description: TODO
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public class Test1 {

    public static void main(String[] args) throws BeanException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("data.xml");
        AService aService = (AService) context.getBean("aService");
        aService.sayHello();
    }

}

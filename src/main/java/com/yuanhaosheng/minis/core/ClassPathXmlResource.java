package com.yuanhaosheng.minis.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 读取 并 解析文件，成 Resource 「格式」，交给 Reader 加载进 factory
 * @Author: yuanhaosheng
 * @Version: 1.0
 */
public class ClassPathXmlResource implements Resource {

    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {
        try {
            SAXReader saxReader = new SAXReader();
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            this.document = saxReader.read(xmlPath);
            this.rootElement = document.getRootElement();
            this.elementIterator = rootElement.elementIterator();
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext() {
        return elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return elementIterator.next();
    }
}

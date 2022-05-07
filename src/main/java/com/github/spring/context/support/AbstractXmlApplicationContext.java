package com.github.spring.context.support;

import com.github.spring.beans.factory.DefaultListableBeanFactory;
import com.github.spring.beans.factory.support.xml.XmlBeanDefinitionReader;

/**
 * xml 上下文
 * @author wang xiao
 * @date 2022/5/7
 */
public class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        /**
         * xml 加载bean
         */
    }
}

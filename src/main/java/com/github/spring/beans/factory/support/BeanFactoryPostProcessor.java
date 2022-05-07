package com.github.spring.beans.factory.support;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * bean factory 处理器
 *  @author wang xiao
 * @date 2022/5/7
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory ConfigurableListableBeanFactory
     * @throws BeanException BeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException;
}

package com.github.spring.beans.factory;

/**
 * 单例bean 工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public interface SingletonBeanFactory {

    /**
     * 获取bean
     * @param beanName bean 名称
     * @return Object
     */
    Object getSingleton(String beanName);
}

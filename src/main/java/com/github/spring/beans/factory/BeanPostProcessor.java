package com.github.spring.beans.factory;

import com.github.spring.beans.BeanException;

/**
 * Bean 实例化 扩展点
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanPostProcessor {


    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean bean
     * @param beanName bean Name
     * @return Object
     * @throws  BeanException com.github.spring.beans.BeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean bean
     * @param beanName bean Name
     * @return Object
     * @throws  BeanException com.github.spring.beans.BeanException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException;
}

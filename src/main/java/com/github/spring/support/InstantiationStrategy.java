package com.github.spring.support;

import com.github.spring.BeanException;
import com.github.spring.core.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 *  实例化策略
 * @author wang xiao
 * @date 2022/5/7
 */
public interface InstantiationStrategy {

    /**
     * 实例化接口
     * @param beanName bean name
     * @param beanDefinition bean definition
     * @param constructor 构造器
     * @param args 参数
     * @return Bean
     * @throws BeanException BeanException
     */
    Object instantiate(String beanName, BeanDefinition<?> beanDefinition, Constructor<?> constructor,Object ... args) throws BeanException;
}

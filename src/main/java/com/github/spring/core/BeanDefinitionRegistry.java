package com.github.spring.core;

/**
 * bean definition 工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册bean definition
     * @param beanName bean name
     * @param beanDefinition beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition<?> beanDefinition);
}

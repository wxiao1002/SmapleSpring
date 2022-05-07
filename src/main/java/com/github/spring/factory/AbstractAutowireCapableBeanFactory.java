package com.github.spring.factory;

import com.github.spring.BeanException;
import com.github.spring.core.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

/**
 * 自动注入 备案
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        }catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new BeanException("Instantiation of bean failed", e);
        }
        registrySingletonBean(beanName,bean);
        return bean;
    }
}

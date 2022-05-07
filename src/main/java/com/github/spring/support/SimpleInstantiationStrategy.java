package com.github.spring.support;

import com.github.spring.BeanException;
import com.github.spring.core.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 简单的实例化工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public class SimpleInstantiationStrategy  implements InstantiationStrategy{
    @Override
    public Object instantiate(String beanName, BeanDefinition<?> beanDefinition, Constructor<?> constructor, Object... args) throws BeanException {
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            if (null != constructor){
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeanException("Failed to instantiate [" + beanName + "]", e);
        }
    }
}

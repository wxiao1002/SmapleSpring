package com.github.spring.support;

import com.github.spring.BeanException;
import com.github.spring.core.BeanDefinition;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Constructor;

/**
 * cglib
 * @author wang xiao
 * @date 2022/5/7
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(String beanName, BeanDefinition<?> beanDefinition, Constructor<?> constructor, Object... args) throws BeanException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new Callback() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor){
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(),args);
    }
}

package com.github.spring.beans.factory;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.BeanDefinition;
import com.github.spring.beans.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * bean 工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String,BeanDefinition<?>> beanDefinitionFactory = new HashMap<>();
    @Override
    protected BeanDefinition<?> getBeanDefinition(String beanName) throws BeanException {
        return beanDefinitionFactory.get(beanName);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition<?> beanDefinition) {
        beanDefinitionFactory.put(beanName,beanDefinition);
    }


}

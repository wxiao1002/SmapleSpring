package com.github.spring.factory;

import com.github.spring.BeanException;
import com.github.spring.core.BeanDefinition;
import com.github.spring.core.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * bean 工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String,BeanDefinition> beanDefinitionFactory = new HashMap<>();
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        return beanDefinitionFactory.get(beanName);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionFactory.put(beanName,beanDefinition);
    }
}

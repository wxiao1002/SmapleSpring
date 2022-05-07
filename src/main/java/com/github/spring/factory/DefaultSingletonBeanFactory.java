package com.github.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class DefaultSingletonBeanFactory implements SingletonBeanFactory{

    private final Map<String,Object> singletonBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeans.get(beanName);
    }

    protected void registrySingletonBean(String beanName,Object bean) {
        singletonBeans.put(beanName,bean);
    }
}

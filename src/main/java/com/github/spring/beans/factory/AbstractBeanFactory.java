package com.github.spring.beans.factory;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.BeanDefinition;
import com.github.spring.beans.BeanFactory;

/**
 * 抽象模版方法  先从单例中寻找  找不到调用 create bean
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeanException {
        return doGetBean(beanName, null);
    }


    @Override
    public Object getBean(String beanName, Object... args) throws BeanException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return (T) getBean(beanName);
    }

    /**
     * 获取bean 定义信息
     * @param beanName bean name
     * @return BeanDefinition
     * @throws BeanException BeanException
     */
    protected abstract BeanDefinition<?> getBeanDefinition(String beanName) throws BeanException;

    /**
     * 创建 bean
     * @param beanName bean name
     * @param beanDefinition beanDefinition
     * @return Object bean
     * @throws BeanException BeanException
     */
    protected abstract Object createBean(String beanName, BeanDefinition<?> beanDefinition) throws BeanException;


    /**
     * 创建 bean
     * @param beanName bean name
     * @param beanDefinition beanDefinition
     * @param args args
     * @return Object bean
     * @throws BeanException BeanException
     */
    protected abstract Object createBean(String beanName, BeanDefinition<?> beanDefinition,Object ... args) throws BeanException;



    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }
}

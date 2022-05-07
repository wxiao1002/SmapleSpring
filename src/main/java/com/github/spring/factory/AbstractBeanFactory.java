package com.github.spring.factory;

import com.github.spring.BeanException;
import com.github.spring.core.BeanDefinition;
import com.github.spring.core.BeanFactory;

/**
 * 抽象模版方法  先从单例中寻找  找不到调用 create bean
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeanException {
        Object bean  = getSingleton(beanName);
        if (bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }

    /**
     * 获取bean 定义信息
     * @param beanName bean name
     * @return BeanDefinition
     * @throws BeanException BeanException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    /**
     * 创建 bean
     * @param beanName bean name
     * @param beanDefinition beanDefinition
     * @return Object bean
     * @throws BeanException BeanException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException;

}

package com.github.spring.beans.factory;

import com.github.spring.beans.BeanDefinition;
import com.github.spring.beans.BeanException;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory{

    /**
     * 获取bean 定义
     * @param beanName bean name
     * @return  BeanDefinition<?>
     * @throws BeanException BeanException
     */
    BeanDefinition<?> getBeanDefinition(String beanName) throws BeanException;

    /**
     * 提前刷新单例bean
     * @throws BeanException BeanException
     */
    void preInstantiateSingletons() throws BeanException;

    /**
     * 添加bean 实例化扩展点
     * @param beanPostProcessor bean 实例化扩展
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例bean
     */
    void destroySingletons();
}

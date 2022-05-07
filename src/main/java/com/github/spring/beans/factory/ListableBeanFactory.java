package com.github.spring.beans.factory;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.BeanFactory;

import java.util.Map;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     * @param type class
     * @param <T> class type
     * @return Bean Map
     * @throws BeanException com.github.spring.beans.BeanException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     * @return String bean names
     */
    String[] getBeanDefinitionNames();
}

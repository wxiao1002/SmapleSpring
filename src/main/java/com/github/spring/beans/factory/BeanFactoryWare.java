package com.github.spring.beans.factory;

import com.github.spring.beans.Aware;
import com.github.spring.beans.BeanException;
import com.github.spring.beans.BeanFactory;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanFactoryWare extends Aware {

    /**
     * 设置bean 工厂后感知
     * @param beanFactory beanFactory
     * @throws BeanException BeanException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeanException;
}

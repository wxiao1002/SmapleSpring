package com.github.spring.core;

import com.github.spring.BeanException;

/**
 * bean 工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanFactory {

    /**
     * 获取bean
     * @param beanName
     * @return
     * @throws BeanException
     */
  Object getBean(String beanName) throws BeanException;
}

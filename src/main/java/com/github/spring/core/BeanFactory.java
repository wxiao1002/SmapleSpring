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
     * @param beanName bean name
     * @return Bean
     * @throws BeanException BeanException
     */
  Object getBean(String beanName) throws BeanException;

    /**
     * 获取bean
     * @param beanName bean name
     * @param args 参数
     * @return Bean
     * @throws BeanException BeanException
     */
  Object getBean(String beanName,Object ... args) throws BeanException;
}

package com.github.spring.beans.factory.support;

import com.github.spring.beans.BeanDefinitionRegistry;
import com.github.spring.beans.BeanException;
import com.github.spring.core.io.Resource;
import com.github.spring.core.io.ResourceLoader;

/**
 * bean definition 读取接口
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanDefinitionReader {

    /**
     * 获取bean definition 注册器
     * @return BeanDefinitionRegistry
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取ResourceLoader
     * @return ResourceLoader
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载 bean definition
     * @param resource 资源
     * @throws BeanException BeanException
     */
    void loadBeanDefinitions(Resource resource) throws BeanException;


    /**
     * 加载 bean definition
     * @param resources 资源
     * @throws BeanException BeanException
     */
    void loadBeanDefinitions(Resource... resources) throws BeanException;


    /**
     * 加载 bean definition
     * @param location 地址
     * @throws BeanException BeanException
     */
    void loadBeanDefinitions(String location) throws BeanException;
}

package com.github.spring.beans.factory.support;

import com.github.spring.beans.BeanDefinitionRegistry;
import com.github.spring.core.io.DefaultResourceLoader;
import com.github.spring.core.io.ResourceLoader;

/**
 * BeanDefinitionReader 抽象实现
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

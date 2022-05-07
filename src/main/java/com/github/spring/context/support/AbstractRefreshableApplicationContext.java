package com.github.spring.context.support;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.factory.ConfigurableListableBeanFactory;
import com.github.spring.beans.factory.DefaultListableBeanFactory;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    protected void refreshBeanFactory() throws BeanException {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        loadBeanDefinitions(factory);
        this.beanFactory = factory;
    }

    /**
     * 加载bean definitions
     * @param beanFactory beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

}

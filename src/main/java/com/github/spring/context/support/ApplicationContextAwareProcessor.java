package com.github.spring.context.support;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.factory.BeanPostProcessor;
import com.github.spring.context.ApplicationContext;
import com.github.spring.context.ApplicationContextAware;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {
        return bean;
    }
}

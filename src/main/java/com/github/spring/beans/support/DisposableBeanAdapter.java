package com.github.spring.beans.support;

import com.github.spring.beans.BeanDefinition;
import com.github.spring.beans.BeanException;
import com.github.spring.beans.factory.DisposableBean;

import java.lang.reflect.Method;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition<?> beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = null != beanDefinition?beanDefinition.getDestroyMethod():null;
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }
        if (null != destroyMethodName && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeanException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}

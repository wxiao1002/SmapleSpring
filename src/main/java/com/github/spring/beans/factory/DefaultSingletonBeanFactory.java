package com.github.spring.beans.factory;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.support.DisposableBeanAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class DefaultSingletonBeanFactory implements SingletonBeanFactory{

    private final Map<String,Object> singletonBeans = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeans.get(beanName);
    }

    /**
     * 注册销毁bean 类
     * @param beanName beanName
     * @param disposableBeanAdapter disposableBeanAdapter
     */
    protected  void registerDisposableBean(String beanName, DisposableBeanAdapter disposableBeanAdapter){
        disposableBeans.put(beanName,disposableBeanAdapter);
    }

    protected void registrySingletonBean(String beanName,Object bean) {
        singletonBeans.put(beanName,bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeanException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}

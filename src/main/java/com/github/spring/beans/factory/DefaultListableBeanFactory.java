package com.github.spring.beans.factory;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.BeanDefinition;
import com.github.spring.beans.BeanDefinitionRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bean 工厂
 * @author wang xiao
 * @date 2022/5/7
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry ,ListableBeanFactory, ConfigurableListableBeanFactory{

    private final Map<String,BeanDefinition<?>> beanDefinitionFactory = new HashMap<>();


    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    @Override
    public BeanDefinition<?> getBeanDefinition(String beanName) throws BeanException {
        return beanDefinitionFactory.get(beanName);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition<?> beanDefinition) {
        beanDefinitionFactory.put(beanName,beanDefinition);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionFactory.forEach((beanName, beanDefinition) -> {
            Class<?> beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionFactory.keySet().toArray(new String[0]);
    }

    @Override
    public void preInstantiateSingletons() throws BeanException {
        beanDefinitionFactory.keySet().forEach(this::getBean);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }



    @Override
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }


}

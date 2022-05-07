package com.github.spring.factory;

import com.github.spring.BeanException;
import com.github.spring.PropertyValue;
import com.github.spring.PropertyValues;
import com.github.spring.core.BeanDefinition;
import com.github.spring.core.BeanReference;
import com.github.spring.support.InstantiationStrategy;
import com.github.spring.support.SimpleInstantiationStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


/**
 * 自动注入 备案
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private final InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition<?> beanDefinition) throws BeanException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        }catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new BeanException("Instantiation of bean failed", e);
        }
        registrySingletonBean(beanName,bean);
        return bean;
    }


    @Override
    protected Object createBean(String beanName, BeanDefinition<?> beanDefinition, Object... args) throws BeanException {
        Object bean = null;
        try {
            bean =  createBeanInstance(beanName,beanDefinition,args);
            applyPropertyValues(beanName,bean,beanDefinition);
        }catch (Exception e){
            throw new BeanException("Instantiation of bean failed", e);
        }
        registrySingletonBean(beanName,bean);
        return bean;
    }

    /**
     * bean 实例化
     * @param beanName bean name
     * @param beanDefinition beanDefinition
     * @param args 参数
     * @return bean
     */
    protected Object createBeanInstance(String beanName, BeanDefinition<?> beanDefinition, Object ... args)  {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?> targetConstructor = null;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors){
            if (null != args && constructor.getParameterTypes().length == args.length){
                targetConstructor = constructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanName,beanDefinition,targetConstructor,args);
    }

    /**
     * 设置bean 属性
     * @param beanName bean name
     * @param bean bean
     * @param beanDefinition propertyValues
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition<?> beanDefinition){
        if (null == bean){
            return;
        }
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue: propertyValues.getPropertyValues()){
                String propertyName = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                    setFieldValue(bean,propertyName,value);
                }else {
                    setFieldValue(bean,propertyName,value);
                }
            }
        }catch (Exception e){
            throw new BeanException("Error setting property values:"+ beanName);
        }

    }

    public static void setFieldValue(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException  {
        Field field = obj.getClass().getDeclaredField(fieldName);
        setFieldValue(obj, field, value);
    }

    public static void setFieldValue(Object obj, Field field, Object value) throws IllegalAccessException {
      field.setAccessible(true);
      field.set(obj,value);
    }

}

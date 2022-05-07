package com.github.spring.beans.factory;

import com.github.spring.beans.*;
import com.github.spring.beans.support.DisposableBeanAdapter;
import com.github.spring.beans.support.InstantiationStrategy;
import com.github.spring.beans.support.SimpleInstantiationStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * 自动注入 备案
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

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
            // 实例化
            bean =  createBeanInstance(beanName,beanDefinition,args);
            // 属性注入
            applyPropertyValues(beanName,bean,beanDefinition);
            // 初始化
            bean = initializeBean(beanName, bean, beanDefinition);
        }catch (Exception e){
            throw new BeanException("Instantiation of bean failed", e);
        }
        // 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
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

    /**
     * bean 初始化操作
     * @param beanName bean name
     * @param bean bean
     * @param beanDefinition bean definition
     * @return bean
     */
    private Object initializeBean(String beanName, Object bean, BeanDefinition<?> beanDefinition) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // 执行bean 感知类逻辑
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryWare) {
                ((BeanFactoryWare) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware){
             //   ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }

        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 执行前置
         wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }


    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition<?> beanDefinition) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (wrappedBean instanceof InitializingBean){
            try {
                ((InitializingBean) wrappedBean).afterPropertiesSet();
            }catch (Exception e){
                throw new BeanException("Invocation of init method of bean[" + beanName + "] failed", e);
            }
        }
        String initMethodName = beanDefinition.getInitMethod();
        if (null != initMethodName){
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            initMethod.invoke(wrappedBean);
        }

    }

    private Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }


    private Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current){
                return result;
            }
            result = current;
        }
        return result;
    }

    private  void setFieldValue(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException  {
        Field field = obj.getClass().getDeclaredField(fieldName);
        setFieldValue(obj, field, value);
    }

    private   void setFieldValue(Object obj, Field field, Object value) throws IllegalAccessException {
      field.setAccessible(true);
      field.set(obj,value);
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition<?> beanDefinition) {
        if (bean instanceof DisposableBean || null != beanDefinition.getDestroyMethod()) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName,beanDefinition));
        }
    }

    /**
     * 获取bean 初始化处理器
     * @return List<BeanPostProcessor>
     */
    public abstract List<BeanPostProcessor> getBeanPostProcessors();

}

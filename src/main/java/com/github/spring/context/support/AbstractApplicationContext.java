package com.github.spring.context.support;

import com.github.spring.beans.BeanException;
import com.github.spring.beans.factory.BeanPostProcessor;
import com.github.spring.beans.factory.ConfigurableListableBeanFactory;
import com.github.spring.beans.factory.support.BeanFactoryPostProcessor;
import com.github.spring.context.ConfigurableApplicationContext;
import com.github.spring.context.event.ApplicationEvent;
import com.github.spring.context.event.ApplicationEventMulticaster;
import com.github.spring.context.event.ApplicationListener;
import com.github.spring.context.event.ContextRefreshedEvent;
import com.github.spring.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeanException {

        // 1. 刷新bean 工厂
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 2.1 增加 beanFactory 感知
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6. 注册事件监听器
        registerListeners();

        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

        // 7. 发布容器刷新完成事件
        finishRefresh();
    }

    /**
     * bean 容器刷新
     * @throws BeanException com.github.spring.beans.BeanException
     */
    protected abstract void refreshBeanFactory() throws BeanException;

    /**
     * 获取bean 工厂
     * @return bean Factory
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeanException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeanException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void publishEvent(ApplicationEvent applicationEvent) {
        applicationEventMulticaster.multicastEvent(applicationEvent);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener<?> listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }
}

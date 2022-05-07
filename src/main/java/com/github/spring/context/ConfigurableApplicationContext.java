package com.github.spring.context;

import com.github.spring.beans.BeanException;

/**
 * 配置上下文
 * @author wang xiao
 * @date 2022/5/7
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeanException com.github.spring.beans.BeanException
     */
    void refresh() throws BeanException;
}

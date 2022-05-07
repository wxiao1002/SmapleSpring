package com.github.spring.context;

import com.github.spring.beans.Aware;
import com.github.spring.beans.BeanException;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public interface ApplicationContextAware extends Aware {

    /**
     * 设置了上下文感知接口
     * @param applicationContext application
     * @throws BeanException BeanException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;
}

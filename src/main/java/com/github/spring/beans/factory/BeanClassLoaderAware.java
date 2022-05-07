package com.github.spring.beans.factory;

import com.github.spring.beans.Aware;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanClassLoaderAware  extends Aware {

    /**
     * 设置了加载气的感知
     * @param classLoader classLoader
     */
    void setBeanClassLoader(ClassLoader classLoader);

}

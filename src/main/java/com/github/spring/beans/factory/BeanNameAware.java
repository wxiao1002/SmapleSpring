package com.github.spring.beans.factory;

import com.github.spring.beans.Aware;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public interface BeanNameAware extends Aware {
    /**
     * bean 名称感知
     * @param name name
     */
    void setBeanName(String name);
}

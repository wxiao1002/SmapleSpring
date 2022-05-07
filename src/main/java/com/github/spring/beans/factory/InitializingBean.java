package com.github.spring.beans.factory;

/**
 * 初始化
 * @author wang xiao
 * @date 2022/5/7
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     * @throws Exception e
     */
    void afterPropertiesSet() throws Exception;
}

package com.github.spring.aop.proxy;

/**
 * @author wang xiao
 * @date 2022/5/9
 */
public interface AopProxy {

    /**
     * 获取代理类
     * @return Object
     */
    Object getProxy();
}

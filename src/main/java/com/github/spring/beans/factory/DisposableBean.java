package com.github.spring.beans.factory;

/**
 * 销毁 bean
 * @author wang xiao
 * @date 2022/5/7
 */
public interface DisposableBean {

    void destroy() throws Exception;
}

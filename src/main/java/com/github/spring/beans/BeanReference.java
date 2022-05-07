package com.github.spring.beans;

/**
 * bean 的引用
 * @author wang xiao
 * @date 2022/5/7
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

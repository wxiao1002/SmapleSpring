package com.github.spring.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配
 * @author wang xiao
 * @date 2022/5/9
 */
public interface MethodMatcher {

    /**
     * 找到表达式范围内匹配下的目标类和方法
     * @param method 方法
     * @param targetClass 类
     * @return boolean
     */
    boolean matches(Method method,Class<?> targetClass);
}

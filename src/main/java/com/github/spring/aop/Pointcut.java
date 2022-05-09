package com.github.spring.aop;

/**
 * 切点
 * @author wang xiao
 * @date 2022/5/9
 */
public interface Pointcut {

    /**
     * 获取类匹配
     * @return ClassFilter
     */
    ClassFilter getClassFilter();

    /**
     * 获取方法匹配
     * @return ClassFilter
     */
    MethodMatcher getMethodMatcher();
}

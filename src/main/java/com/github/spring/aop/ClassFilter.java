package com.github.spring.aop;

/**
 * 类匹配类
 * @author wang xiao
 * @date 2022/5/9
 */
public interface ClassFilter {

    /**
     * 判断类是否匹配
     * @param clazz 类
     * @return boolean
     */
    boolean matches(Class<?> clazz);
}

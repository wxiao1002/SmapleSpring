package com.github.spring.aop;

/**
 * 被代理的目标对象
 * @author wang xiao
 * @date 2022/5/9
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?> [] getTargetClass() {
        return target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}

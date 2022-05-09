package com.github.spring.context.event;

/**
 * 容器刷新事件
 * @author wang xiao
 * @date 2022/5/9
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}

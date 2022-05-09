package com.github.spring.context.event;

/**
 * 事件发布者
 * @author wang xiao
 * @date 2022/5/9
 */
public interface ApplicationEventPublisher {

    /**
     * 发布事件
     * @param applicationEvent event
     */
    void publishEvent(ApplicationEvent applicationEvent);
}

package com.github.spring.context.event;

/**
 * 事件广播器
 * @author wang xiao
 * @date 2022/5/9
 */
public interface ApplicationEventMulticaster {


    /**
     * 添加事件监听者
     * @param listener 监听
     */
    void addApplicationListener(ApplicationListener<?> listener);


    /**
     * 移除事件监听者
     * @param listener 监听
     */
    void removeApplicationListener(ApplicationListener<?> listener);


    /**
     * 广播事件
     * @param event event
     */
    void multicastEvent(ApplicationEvent event);
}
